package com.hou.mybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 自动填充字段处理
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //必须使用父类的setFieldValByName()或者setInsertFieldValByName/setUpdateFieldValByName方法，
    // 否则不会根据注解FieldFill.xxx来区分
    @Override
    public void insertFill(MetaObject metaObject) {
        for (String getterName : metaObject.getGetterNames()) {
            System.out.println("-----"+getterName);//获取这个实体的所有字段名,很久字段名分别处理填充字段
        }
        //获取需要填充的class
        metaObject.getOriginalObject().getClass();
        //可获取已传入的值进行处理
        //System.out.println(metaObject.getValue("type"));
        //填充字段值
        //this.setFieldValByName("orderId",5,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //DefaultSqlInjector.

    }
}
