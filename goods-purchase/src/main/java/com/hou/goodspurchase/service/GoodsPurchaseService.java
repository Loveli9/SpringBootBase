package com.hou.goodspurchase.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 商品抢购业务层
 */
public interface GoodsPurchaseService {

    /**
     * 商品抢购
     * @param userId 购买用户
     * @param productId 商品id
     * @param num 购买数量
     * @return 是否购买成功
     */
    Boolean goodsPurchase(String userId, String productId, Integer num);
}
