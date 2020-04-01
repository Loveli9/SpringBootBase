package com.hou.goodspurchase.controller;

import com.hou.goodspurchase.service.GoodsPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品抢购
 */
@RestController
@RequestMapping("/purchase")
public class GoodsPurchaseController {

    @Autowired
    private GoodsPurchaseService goodsPurchaseService;

    @GetMapping("/goods")
    public String goodsPurchase(String productId,String userId,Integer num){
        System.out.println("进入方法成功");
        Boolean result = goodsPurchaseService.goodsPurchase(userId, productId, num);
        return result==true?"抢购成功":"抢购失败";
    }



}
