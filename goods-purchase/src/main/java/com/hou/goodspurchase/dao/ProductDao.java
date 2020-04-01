package com.hou.goodspurchase.dao;

import com.hou.goodspurchase.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDao {

    Product getProductById(@Param("id") String id);

    int decreaseStock(@Param("id") String id,@Param("num") Integer num);


}
