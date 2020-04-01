package com.hou.designpattern.strategy.service.impl;

import com.hou.designpattern.strategy.bean.Order;
import com.hou.designpattern.strategy.config.HandlerOrderContext;
import com.hou.designpattern.strategy.service.OrderService;
import com.hou.designpattern.strategy.strategys.OrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    HandlerOrderContext handlerOrderContext;
    @Override
    public void handleOrder(Order order) {
        //使用策略处理订单
        OrderStrategy orderStrategy = handlerOrderContext.getOrderStrategy(order.getType());
        orderStrategy.handleOrder(order);
    }
}
