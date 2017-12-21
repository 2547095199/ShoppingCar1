package com.bwie.huang.shoppingcar1.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwie.huang.shoppingcar1.R;
import com.bwie.huang.shoppingcar1.fragment.AllFragment;
import com.bwie.huang.shoppingcar1.fragment.CancelFragment;
import com.bwie.huang.shoppingcar1.fragment.PayedFragment;
import com.bwie.huang.shoppingcar1.fragment.WaitFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton rbAll;
    private RadioButton rbWait;
    private RadioButton rbPayed;
    private RadioButton rbCancel;
    private ViewPager viewpager;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        MyApapter apapter=new MyApapter(getSupportFragmentManager());
        viewpager.setAdapter(apapter);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_all:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.rb_wait:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.rb_payed:
                        viewpager.setCurrentItem(2);
                        break;
                    case R.id.rb_cancel:
                        viewpager.setCurrentItem(3);
                        break;

                }
            }
        });
    }

    private void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
        rbAll = (RadioButton) findViewById(R.id.rb_all);
        rbWait = (RadioButton) findViewById(R.id.rb_wait);
        rbPayed = (RadioButton) findViewById(R.id.rb_payed);
        rbCancel = (RadioButton) findViewById(R.id.rb_cancel);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        list = new ArrayList<>();
        list.add(new AllFragment());
        list.add(new WaitFragment());
        list.add(new PayedFragment());
        list.add(new CancelFragment());
    }
    class MyApapter extends FragmentPagerAdapter{

        public MyApapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

}
