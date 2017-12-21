package com.bwie.huang.shoppingcar1.model;

import com.bwie.huang.shoppingcar1.bean.ShopBean;
import com.bwie.huang.shoppingcar1.net.OkhttpUtils;
import com.bwie.huang.shoppingcar1.net.OnUiCallback;

/**
 * Date:2017/12/19
 * time:14:03
 * author:HuangZhangpeng
 */
public class CarModel {

    public void getData(final ModelListener listener){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=100", new OnUiCallback<ShopBean>() {
            @Override
            public void success(ShopBean bean) {
                listener.success(bean);
            }

            @Override
            public void failure(Exception e) {

            }
        });
    }

}
