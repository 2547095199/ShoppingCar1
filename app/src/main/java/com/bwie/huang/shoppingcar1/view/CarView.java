package com.bwie.huang.shoppingcar1.view;

import com.bwie.huang.shoppingcar1.bean.ShopBean;

/**
 * Date:2017/12/19
 * time:14:07
 * author:HuangZhangpeng
 */
public interface CarView {
    void success(ShopBean bean);
    void failure(Exception e);
}
