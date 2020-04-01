package com.hou.goodspurchase.dao;

import com.hou.goodspurchase.pojo.BuyInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyInfoDao {

    int insertBuyInfo(BuyInfo buyInfo);
}
