package com.hou.designpattern.strategy.service;

import com.hou.designpattern.strategy.bean.Order;
import com.hou.designpattern.strategy.config.HandlerOrderContext;
import com.hou.designpattern.strategy.strategys.OrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;

public interface OrderService {
    /**
     * 处理订单
     * @param order
     */
    void handleOrder(Order order);
}
