package com.hou.designpattern.strategy.strategys.impl;

import com.hou.designpattern.strategy.annotation.HandlerOrderType;
import com.hou.designpattern.strategy.bean.Order;
import com.hou.designpattern.strategy.strategys.OrderStrategy;
import org.springframework.stereotype.Component;

@Component
@HandlerOrderType(Order.DISCOUT)
public class DiscoutOrderStrategy implements OrderStrategy {
    @Override
    public void handleOrder(Order order) {
        System.out.println("----处理打折订单----");
    }
}
