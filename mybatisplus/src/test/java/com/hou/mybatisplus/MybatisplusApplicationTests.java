package com.hou.mybatisplus;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.hou.mybatisplus.user.entity.User;
import com.hou.mybatisplus.user.entity.UserOrder;
import com.hou.mybatisplus.user.enums.OrderTypeEnum;
import com.hou.mybatisplus.user.mapper.UserMapper;
import com.hou.mybatisplus.user.mapper.UserOrderMapper;
import com.hou.mybatisplus.user.service.IUserOrderService;
import com.hou.mybatisplus.user.service.IUserService;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntUnaryOperator;

import static org.hibernate.validator.internal.util.CollectionHelper.newHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserOrderMapper userOrderMapper;
    @Autowired
    IUserOrderService userOrderService;
    @Autowired
    IUserService userService;

    /**
     * 测试 mapper
     */
    @Test
    //@DS("master") 不配置默认纯读写分离,则需要手动切换数据源
    public void contextLoads() {
        userMapper.selectList(null).forEach(System.out::println);
        //userMapper.
        userMapper.insert(new User());
    }

    /**
     * 测试 userService,内置方法
     */
    @Test
    public void testService() {
        userService.getById(1);
        //getMap: 有多个值默认只返回第一个, getOne 有多个抛异常
        userService.getMap(Wrappers.<User>lambdaQuery() //使用lambda
                .ge(false,User::getId, 4) // 条件 condition: 是否将条件加入最后sql中
                .select(User::getAge,User::getName)); //显示字段
        // list
        userService.list(Wrappers.<User>query().between("id", 2, 4).orderByDesc("id"));
        userService.getBaseMapper().selectById(1); // service调用mapper方法
        Map<String, Object> param = Maps.newHashMap("id", 5);
        param.put("age","24");
        userService.listByMap(param); //根据map参数查询
        //getObj 查询带 Objs 的 只返回第一个字段,一般是id
        userService.getObj(Wrappers.<User>lambdaQuery() //使用lambda
                .ge(true, User::getId, 4), x -> Maps.newHashMap("id", x));// {id=4}
        //page
        IPage<User> page = userService.page(new Page<>(1, 1, true));
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        //count
        userService.count();
        //saveOrUpdate
        //userService.saveOrUpdate(new User());// @TableId注解的id如果有就更新
        //条件构造器
        Map<SFunction<User,?>, Object> params=Maps.newHashMap(User::getId,5);
        params.put(User::getAge,null);
        //null2IsNull : 为true则在map的value为null时调用 isNull 方法,为false时则忽略
        Wrappers.<User>lambdaQuery().allEq(params,true);
        // k,y 参数map的key,value
        userService.getMap(Wrappers.<User>query().allEq((k, y) -> k.equals("id"), Maps.newHashMap("id", "5")));
        Wrappers.<User>query().eq("id",5)
                .ne("age",23)
                .like("name","王")  // like %王%
                .likeLeft("name","Tom")  // like %Tom
                .isNull("email")  // is null
                .in("id", Lists.newArrayList(1,2,3))
                .inSql("id","1,2,3")
                .or(x->x.ge("id",5).ne("id","3"))  //嵌套  or (id <5 and id >3)
                // 使用{} 不会有sql注入风险
                .apply("data > {0} and data < {1}","now()","2019") //拼接SQL
                .last("limit 1")  //拼接到最后,无视一切规则
                .exists("select id from table where age = 1");
        //使用逻辑删除配置后，调用内置删除只会修改逻辑字段
        userService.removeById(1);
        userService.getById(1);//逻辑删除的不会查询出来
        userService.getById(2);

    }

    @Test
    public void testUserOrder(){
        //插入
        userOrderService.save(UserOrder.builder().type(OrderTypeEnum.STORE).build());
        System.out.println(userOrderService.getById(1));
        //userOrderMapper.delete(null);//全表删除
    }

}
