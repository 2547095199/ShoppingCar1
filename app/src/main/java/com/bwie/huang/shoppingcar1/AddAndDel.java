package com.bwie.huang.shoppingcar1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Date:2017/12/19
 * time:18:08
 * author:HuangZhangpeng
 */
public class AddAndDel extends LinearLayout {
    int mcount=1;
    private Button btnAdd;
    private Button btnDel;
    private EditText etCount;

    public AddAndDel(Context context) {
        super(context);
    }

    public AddAndDel(Context context, AttributeSet attrs) {
        super(context, attrs);
        View inflate = LayoutInflater.from(context).inflate(R.layout.add_del_layout, null, false);
        btnAdd = inflate.findViewById(R.id.btn_add);
        btnDel = inflate.findViewById(R.id.btn_del);
        etCount = inflate.findViewById(R.id.et_count);
        /**
         * 加一
         */
        btnAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = etCount.getText().toString().trim();
                Integer  count1= Integer.valueOf(count)+1;
                mcount=count1;
                etCount.setText(count1+"");
                if(listener!=null){
                    listener.click(count1);
                }

            }
        });
        /**
         * 减一
         */
        btnDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = etCount.getText().toString().trim();
                Integer count2 = Integer.valueOf(count);
                mcount=count2;
                if(count2>1){
                    mcount=count2-1;
                    etCount.setText(mcount+"");
                    if(listener!=null){
                        listener.click(mcount);
                    }
                }

            }
        });

        addView(inflate);
    }

    public AddAndDel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setEditText(int count){
        if(etCount!=null){
            etCount.setText(count+"");
        }

    }


    private ClickListener listener;
    public void setListener(ClickListener listener){
        this.listener=listener;
    }
    public interface ClickListener{
        void click(int count);
    }
}
