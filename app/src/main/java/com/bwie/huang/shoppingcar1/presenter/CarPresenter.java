package com.bwie.huang.shoppingcar1.presenter;

import com.bwie.huang.shoppingcar1.bean.ShopBean;
import com.bwie.huang.shoppingcar1.model.CarModel;
import com.bwie.huang.shoppingcar1.model.ModelListener;
import com.bwie.huang.shoppingcar1.view.CarView;

/**
 * Date:2017/12/19
 * time:14:08
 * author:HuangZhangpeng
 */
public class CarPresenter {
    private CarView view;
    private CarModel model;
    public CarPresenter(CarView view) {
        this.view = view;
        model=new CarModel();
    }

   public void getData(){
       model.getData(new ModelListener() {
           @Override
           public void success(ShopBean shopBean) {
               view.success(shopBean);
           }

           @Override
           public void failure(Exception e) {

           }
       });
   }
    /**
     * 解除绑定
     */
    public void dettach(){
        this.view=null;
    }
}
