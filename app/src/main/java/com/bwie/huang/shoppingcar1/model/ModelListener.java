package com.bwie.huang.shoppingcar1.model;

import com.bwie.huang.shoppingcar1.bean.ShopBean;

/**
 * Date:2017/12/19
 * time:14:02
 * author:HuangZhangpeng
 */
public interface ModelListener {
   void success(ShopBean shopBean);
    void failure(Exception e);
}
