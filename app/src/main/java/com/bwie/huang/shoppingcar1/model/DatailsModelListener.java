package com.bwie.huang.shoppingcar1.model;

import com.bwie.huang.shoppingcar1.bean.DetailsBean;

/**
 * Date:2017/12/20
 * time:9:45
 * author:HuangZhangpeng
 */
public interface DatailsModelListener {
    void success(DetailsBean bean);
    void failure(Exception e);
}
