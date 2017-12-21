package com.bwie.huang.shoppingcar1.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.huang.shoppingcar1.R;
import com.bwie.huang.shoppingcar1.bean.OrderBean;

import java.util.List;

/**
 * Date:2017/12/20
 * time:19:49
 * author:HuangZhangpeng
 */
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    private Context context;
    private List<OrderBean.DataBean> list;

    public OrderAdapter(Context context, List<OrderBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.order_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final OrderAdapter.MyViewHolder holder, int position) {
        OrderBean.DataBean dataBean = list.get(position);
        holder.orderTime.setText("创建时间："+dataBean.getCreatetime());
        holder.orderTitle.setText(dataBean.getTitle()+"");
        holder.orderPrice.setText("优惠价：¥"+dataBean.getPrice()+"");
        holder.orderPrice.setTextColor(Color.RED);
        int status = dataBean.getStatus();
        holder.orderStatus.setTextColor(Color.parseColor("#000000"));
        if(status==0){
            holder.orderStatus.setTextColor(Color.parseColor("#ff0000"));
            holder.orderStatus.setText("待支付");
            holder.orderBtn.setText("取消订单");
        }else if(status==1){
            holder.orderStatus.setText("已取消");
            holder.orderBtn.setText("查看订单");
        }else if(status==2){
            holder.orderStatus.setText("已支付");
            holder.orderBtn.setText("查看订单");
        }

        holder.orderBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("onClick: ","=======================");
                AlertDialog.Builder dialog=new AlertDialog.Builder(context);
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
                        holder.orderStatus.setTextColor(Color.parseColor("#000000"));
                        holder.orderStatus.setText("已取消");
                    }
                }).create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder{

         private final TextView orderTitle;
         private final TextView orderPrice;
         private final TextView orderTime;
         private final TextView orderStatus;
         private final TextView orderBtn;

         public MyViewHolder(View itemView) {
             super(itemView);
             orderTitle = itemView.findViewById(R.id.order_title);
             orderPrice = itemView.findViewById(R.id.order_price);
             orderTime = itemView.findViewById(R.id.order_time);
             orderStatus = itemView.findViewById(R.id.order_status);
             orderBtn = itemView.findViewById(R.id.order_btn);


         }
     }
   }

