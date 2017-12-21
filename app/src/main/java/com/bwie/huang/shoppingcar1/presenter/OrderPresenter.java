package com.bwie.huang.shoppingcar1.presenter;

import com.bwie.huang.shoppingcar1.bean.OrderBean;
import com.bwie.huang.shoppingcar1.model.OrderModel;
import com.bwie.huang.shoppingcar1.model.OrderModelListener;
import com.bwie.huang.shoppingcar1.view.OrderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/12/20
 * time:19:47
 * author:HuangZhangpeng
 */
public class OrderPresenter {
    private OrderView view;
    private OrderModel model;

    public OrderPresenter(OrderView view) {
        this.view = view;
        model=new OrderModel();
    }


    public void getData(){
        model.getData(new OrderModelListener() {
            @Override
            public void success(OrderBean bean) {
                view.show(bean);
            }

            @Override
            public void failure(Exception e) {

            }
        });
    }
    public void getSortData(String sort){
        model.getSortData(sort,new OrderModelListener() {
            @Override
            public void success(OrderBean bean) {
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
