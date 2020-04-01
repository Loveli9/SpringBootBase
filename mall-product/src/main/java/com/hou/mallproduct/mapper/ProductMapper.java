package com.hou.mallproduct.mapper;

import java.util.List;

import com.hou.mallproduct.bean.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



//springboot会根据注解和sql语句自动提供实现类
@Mapper   //用注解来配置映射的sql语句，这样可以省掉映射器xml文件
public interface ProductMapper {

    @Insert("insert into products (pid,pname,ptype,pprice) values(#{pid},#{pname},#{ptype},#{pprice})")
    public Integer add(Product product);

    @Delete("delete from products where pid=#{arg1}")
    public Integer deleteById(String id);

    @Update("update products set pname=#{pname},ptype=#{ptype},pprice=#{pprice} where pid=#{id}")
    public Integer update(Product product);

    @Select("select * from products where pid=#{arg1}")
    public Product selectById(String id);

    @Select("select * from products order by createtime desc")
    public List<Product> selectByPage();

}
