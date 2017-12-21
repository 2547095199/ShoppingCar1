package com.bwie.huang.shoppingcar1.model;

import com.bwie.huang.shoppingcar1.bean.DetailsBean;
import com.bwie.huang.shoppingcar1.net.OkhttpUtils;
import com.bwie.huang.shoppingcar1.net.OnUiCallback;

/**
 * Date:2017/12/20
 * time:9:44
 * author:HuangZhangpeng
 */
public class DatailsModel {

    public void getData(final DatailsModelListener listener){
        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getProductDetail?pid=48&uid=71", new OnUiCallback<DetailsBean>() {
            @Override
            public void success(DetailsBean bean) {
                 listener.success(bean);
            }

            @Override
            public void failure(Exception e) {

            }
        });
    }
}
