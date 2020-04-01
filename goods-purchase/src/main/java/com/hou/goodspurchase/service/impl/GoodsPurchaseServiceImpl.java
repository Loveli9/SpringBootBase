package com.hou.goodspurchase.service.impl;

import com.hou.goodspurchase.dao.BuyInfoDao;
import com.hou.goodspurchase.dao.ProductDao;
import com.hou.goodspurchase.pojo.BuyInfo;
import com.hou.goodspurchase.pojo.Product;
import com.hou.goodspurchase.service.GoodsPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class GoodsPurchaseServiceImpl implements GoodsPurchaseService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BuyInfoDao buyInfoDao;
    @Override
    @Transactional   //add事务控制
    public Boolean goodsPurchase(String userId, String productId, Integer num) {
        //查询商品库存是否充足
        Product product = productDao.getProductById(productId);
        if(product==null || product.getStock()<num)return false;
        //减库存
        productDao.decreaseStock(productId,num);
        //添加用户购买记录
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        BuyInfo buyInfo = new BuyInfo(id, userId, productId, num, num * product.getUnitPrice(), "特价商品抢购");
        buyInfoDao.insertBuyInfo(buyInfo);
        return true;
    }
}
