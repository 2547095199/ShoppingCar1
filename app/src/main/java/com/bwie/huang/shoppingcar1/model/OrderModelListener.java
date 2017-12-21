package com.bwie.huang.shoppingcar1.model;

import com.bwie.huang.shoppingcar1.bean.OrderBean;

/**
 * Date:2017/12/20
 * time:19:40
 * author:HuangZhangpeng
 */
public interface OrderModelListener {
    void success(OrderBean bean);
    void failure(Exception e);
}
