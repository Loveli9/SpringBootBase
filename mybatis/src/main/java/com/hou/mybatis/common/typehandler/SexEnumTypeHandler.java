package com.hou.mybatis.common.typehandler;

import com.hou.mybatis.domain.ENUM.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

//枚举转换
@MappedJdbcTypes(JdbcType.INTEGER) //声明JDBC类型为整型,即数据库中对应字段类型
@MappedTypes(value = SexEnum.class)  //声明需要转换的java类
public class SexEnumTypeHandler extends BaseTypeHandler<SexEnum> {
    //设置非空性别参数
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());
    }
    //通过名称读取性别
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int  sex=  resultSet.getInt(s);
        if  (sex  !=  1  &&  sex  !=  2)return  null ;
        return Arrays.asList(SexEnum.values()).stream().filter(x -> x.getId()==sex).collect(Collectors.toList()).get(0);
    }
    //通过下标读取性别
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int  sex=  resultSet.getInt(i);
        if  (sex  !=  1  &&  sex  !=  2)return  null ;
        return Arrays.asList(SexEnum.values()).stream().filter(x ->x.getId()==sex).collect(Collectors.toList()).get(0);
    }
    //通过存储过程读取性别
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int  sex=  callableStatement.getInt(i);
        if  (sex  !=  1  &&  sex  !=  2)return  null ;
        return Arrays.asList(SexEnum.values()).stream().filter(x -> x.getId()==sex).collect(Collectors.toList()).get(0);
    }
}
