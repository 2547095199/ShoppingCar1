package com.bwie.huang.shoppingcar1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.huang.shoppingcar1.R;

public class ConfirmActivity extends AppCompatActivity {

    private TextView xiaofei;
    private TextView seeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        initView();
        Intent intent = getIntent();
        String money = intent.getStringExtra("money");
        xiaofei.setText(money+"");
        seeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConfirmActivity.this, OrderActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void initView() {
        xiaofei = (TextView) findViewById(R.id.xiaofei);
        seeOrder = (TextView) findViewById(R.id.seeOrder);
    }

}
