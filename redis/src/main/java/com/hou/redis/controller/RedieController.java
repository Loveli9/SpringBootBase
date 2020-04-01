package com.hou.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.*;

@RestController
@RequestMapping("/redis")
public class RedieController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //string
    @GetMapping("/string")
    public String optString(){
        //value默认使用jdk序列,所以不能运算,除非设置string序列化
        redisTemplate.opsForValue().set("str01","侯征");
        //stringRedisTemplate序列化为string存储的是字符串,可以运算
        stringRedisTemplate.opsForValue().set("optstr","66");//可以进行运算
        stringRedisTemplate.opsForValue().increment("optstr",5);//加5
        return stringRedisTemplate.opsForValue().get("optstr");
    }
    //hash:  Map<String,Object>
    @GetMapping("/hash")
    public Map optHash(){
        Map<String,String> map=new HashMap<>();
        map.put("param01","value01");
        map.put("param02","value02");
        stringRedisTemplate.opsForHash().putAll("map01",map);
        stringRedisTemplate.opsForHash().put("map01","param03","value03");//向,map01的hash添加一个值
        //绑定key进行连续操作
        BoundHashOperations<String, Object, Object> hashOps = stringRedisTemplate.boundHashOps("map01");
        hashOps.delete("param01","param02"); //删除
        hashOps.put("param04","value04"); //添加
        Map<Object, Object> map01 = stringRedisTemplate.opsForHash().entries("map01");//获取一个hash
        return map01;
    }
    //list  链表
    @GetMapping("/list")
    public List optList(){
        //从左进添加,下标从0开始
        stringRedisTemplate.opsForList().leftPushAll("list01","v0","v1");
        //从右进添加
        stringRedisTemplate.opsForList().rightPushAll("list02","v0","v1");
        //绑定操作
        BoundListOperations<String, String> boundListOps = stringRedisTemplate.boundListOps("list02");
        boundListOps.leftPop();//从左边取出一个元素 //v0
        boundListOps.index(3);//根据下标获取元素
        boundListOps.leftPush("v0"); //从左边添加
        Long size = boundListOps.size();//链表长度
        //获取下标范围长度  0-  size-1
        List<String> result = boundListOps.range(0, size - 1);
        return result;
    }
    //set   集合,无序不重复
    @GetMapping("/set")
    public Set optSet(){
        //s2只会添加一个
        stringRedisTemplate.opsForSet().add("set01","s1","s2","s2");
        stringRedisTemplate.opsForSet().add("set02","s1","s2","s4","s3");
        BoundSetOperations<String, String> boundSetOps = stringRedisTemplate.boundSetOps("set01");
        boundSetOps.add("s3","s4");//增
        boundSetOps.remove("s1","s3");//删
        boundSetOps.size();//长度
        Set<String> set01 = boundSetOps.members();//获取所有元素
        //交集
        Set<String> inter = boundSetOps.intersect("set02");
        //求交集并保存到一个新的集合中, 指定新set key
        boundSetOps.intersectAndStore("set02","inter");
        //求差集并保存到新的集合
        boundSetOps.diffAndStore("set02","didd");
        //求并集
        boundSetOps.unionAndStore("set02","union");
        return set01;
    }
    //zset
    @GetMapping("/zset")
    public Set optZSet(){
        //使用spring提供的接口TypedTuple构造Zset
        Set<ZSetOperations.TypedTuple<String>> typedTuples = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            double score=i*0.1; //分数
            //创建对象存入值和排序分数
            ZSetOperations.TypedTuple<String> defaultTypedTuple = new DefaultTypedTuple<String>("z"+i,score);
            typedTuples.add(defaultTypedTuple);
        }
        stringRedisTemplate.opsForZSet().add("zset01",typedTuples);//添加
        BoundZSetOperations<String, String> zSetOperations = stringRedisTemplate.boundZSetOps("zset01");
        zSetOperations.add("z9",0.54);//添加
        Set<String> range = zSetOperations.range(1, 6);//按下标获取
        Set<String> strings = zSetOperations.rangeByScore(0.2, 0.6);//按分数范围获取
        //自定义值范围获取
        RedisZSetCommands.Range rangeResult=new RedisZSetCommands.Range();
        rangeResult.gt("z3");//分数大于z3的
        rangeResult.lte("z9");//分数小于等于z9的
        //按自定义取值,并排序,这里排序按字符串排序
        Set<String> rangeByLex = zSetOperations.rangeByLex(rangeResult);
        zSetOperations.remove("z1");//删
        //根据下标获取值与分数,按分数排序
        Set<ZSetOperations.TypedTuple<String>> typedTuples2 = zSetOperations.rangeWithScores(2, 6);
        //根据分数获取值与分数,按分数排序
        Set<ZSetOperations.TypedTuple<String>> typedTuples1 = zSetOperations.rangeByScoreWithScores(0.3, 0.9);
        Set<String> strings1 = zSetOperations.reverseRange(1, 9);//从大到小排序,默认是从小到大
        return rangeByLex;
    }
    //事务
    @GetMapping("/multi")
    public String optMulti(){
        //设置事务监控的key
        redisTemplate.opsForValue().set("multiKey","multiValue");
        //开启事务
        List list = (List) redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.watch("multiKey");//设置监控的key
                //开启事务.在exec执行之前,都只是进入队列,不执行
                operations.multi();
                operations.opsForValue().set("multiKey01", "value01");
                operations.opsForValue().get("multiKey01");//获取值为null,上面还没执行
                //此处抛异常,但是事务会照常执行
                operations.opsForValue().increment("multiKey01", 1);
                //先判断multiKey是否在被监控之后修改过,没修改再执行事务
                return operations.exec();
            }
        });
        System.out.println(list);
        return "ok";
    }

    //流水线
    @GetMapping("/pipeLine")
    public String optPipeLine(){
        //没有任何附加条件,执行一系列命令
        long start = System.currentTimeMillis();
        List list = (List) redisTemplate.executePipelined(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i = 0; i <100000 ; i++) {//执行10万条插入命令
                    redisOperations.opsForValue().set("piKey"+i,"value");
                }
                return null;
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("共用时:"+(end-start)+"毫秒");
        return "ok";
    }
}
