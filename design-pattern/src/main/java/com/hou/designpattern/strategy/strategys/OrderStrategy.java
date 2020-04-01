package com.hou.designpattern.strategy.strategys;

import com.hou.designpattern.strategy.bean.Order;

/**
 * 处理订单策略
 */
public interface OrderStrategy {

    void handleOrder(Order order);
}
