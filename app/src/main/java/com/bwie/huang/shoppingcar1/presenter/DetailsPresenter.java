package com.bwie.huang.shoppingcar1.presenter;

import com.bwie.huang.shoppingcar1.bean.DetailsBean;
import com.bwie.huang.shoppingcar1.model.DatailsModel;
import com.bwie.huang.shoppingcar1.model.DatailsModelListener;
import com.bwie.huang.shoppingcar1.view.DetailsView;

/**
 * Date:2017/12/20
 * time:10:13
 * author:HuangZhangpeng
 */
public class DetailsPresenter {
    private DetailsView view;
    private DatailsModel model;

    public DetailsPresenter(DetailsView view) {
        this.view = view;
        model=new DatailsModel();
    }
    public void getData(){
        model.getData(new DatailsModelListener() {
            @Override
            public void success(DetailsBean bean) {
                view.show(bean);
            }

            @Override
            public void failure(Exception e) {

            }
        });
    }


    public void dettach(){
        this.view=null;
    }
}
