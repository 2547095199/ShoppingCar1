package com.bwie.huang.shoppingcar1.model;

import com.bwie.huang.shoppingcar1.bean.OrderBean;
import com.bwie.huang.shoppingcar1.net.OkhttpUtils;
import com.bwie.huang.shoppingcar1.net.OnUiCallback;

/**
 * Date:2017/12/20
 * time:19:40
 * author:HuangZhangpeng
 */
public class OrderModel {
    public void getData(final OrderModelListener listener) {
        OkhttpUtils.getInstance().asy(null, "https://www.zhaoapi.cn/product/getOrders?uid=71", new OnUiCallback<OrderBean>() {
            @Override
            public void success(OrderBean bean) {
                listener.success(bean);
            }

            @Override
            public void failure(Exception e) {
                listener.failure(e);
            }
        });

    }

    public void getSortData(String status,final OrderModelListener listener) {
        OkhttpUtils.getInstance().asy(null, "https://www.zhaoapi.cn/product/getOrders?uid=71"+"&status="+status, new OnUiCallback<OrderBean>() {
            @Override
            public void success(OrderBean bean) {
                listener.success(bean);
            }

            @Override
            public void failure(Exception e) {
                listener.failure(e);
            }
        });

    }
}
