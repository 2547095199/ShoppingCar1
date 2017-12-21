package com.bwie.huang.shoppingcar1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.huang.shoppingcar1.activity.ConfirmActivity;
import com.bwie.huang.shoppingcar1.activity.OrderActivity;
import com.bwie.huang.shoppingcar1.adapter.CarAdapter;
import com.bwie.huang.shoppingcar1.bean.ShopBean;
import com.bwie.huang.shoppingcar1.presenter.CarPresenter;
import com.bwie.huang.shoppingcar1.view.CarView;

public class MainActivity extends AppCompatActivity implements CarView,View.OnClickListener{

    private CheckBox cbSellectAll;
    private TextView totalPrice;
    private TextView totalCount;
    private RecyclerView recyclerView;
    private CarPresenter presenter;
    private CarAdapter adapter;
    private TextView payment;
   private String total1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new CarPresenter(this);
        presenter.getData();
        adapter = new CarAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter.setListener(new CarAdapter.UpdateListener() {
            @Override
            public void setTotal(String total, String num, boolean bool) {
                total1=total;
                totalPrice.setText("合计："+total+"元");
                totalCount.setText("共"+num+"件");
                cbSellectAll.setChecked(bool);
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ConfirmActivity.class);
                intent.putExtra("money",total1+"");
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        cbSellectAll = (CheckBox) findViewById(R.id.selectAll);
        totalPrice = (TextView)findViewById(R.id.totalPrice);
        totalCount = (TextView)findViewById(R.id.totalCount);
        payment = (TextView) findViewById(R.id.payment);
        cbSellectAll.setOnClickListener(this);
    }

    @Override
    public void success(ShopBean bean) {
        adapter.add(bean);
    }

    @Override
    public void failure(Exception e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }

    /**
     * 全选与全不选
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.selectAll:
                adapter.selectAll(cbSellectAll.isChecked());
                break;
        }
    }



}
