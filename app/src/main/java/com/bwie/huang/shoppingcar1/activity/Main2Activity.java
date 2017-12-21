package com.bwie.huang.shoppingcar1.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.huang.shoppingcar1.MainActivity;
import com.bwie.huang.shoppingcar1.R;
import com.bwie.huang.shoppingcar1.bean.DetailsBean;
import com.bwie.huang.shoppingcar1.presenter.DetailsPresenter;
import com.bwie.huang.shoppingcar1.view.DetailsView;

public class Main2Activity extends AppCompatActivity implements DetailsView, View.OnClickListener {

    private ImageView img;
    private TextView title;
    private TextView price;
    private TextView barginPrice;
    private TextView cart;
    private TextView intoCart;
    private DetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        presenter = new DetailsPresenter(this);
        presenter.getData();
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        title = (TextView) findViewById(R.id.title);
        price = (TextView) findViewById(R.id.price);
        barginPrice = (TextView) findViewById(R.id.barginPrice);
        cart = (TextView) findViewById(R.id.cart);
        intoCart = (TextView) findViewById(R.id.intoCart);
        cart.setOnClickListener(this);
        intoCart.setOnClickListener(this);
    }

    @Override
    public void show(DetailsBean bean) {
        String[] split = bean.getData().getImages().split("\\|");
        Glide.with(this).load(split[0]).into(img);
        title.setText(bean.getData().getTitle());
        price.setText("原价："+bean.getData().getPrice() );
        barginPrice.setText("优惠价："+bean.getData().getBargainPrice() + "");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart:
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.intoCart:
                dialog();
                break;
        }
    }

    private void dialog() {
        Log.i("onClick: ","=======================");
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("提示")
                .setMessage("确定取消订单吗？")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //holder.orderBtn.setText("查看订单");
                    }
                }).create().show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }
}
