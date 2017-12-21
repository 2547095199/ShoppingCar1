package com.bwie.huang.shoppingcar1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.huang.shoppingcar1.AddAndDel;
import com.bwie.huang.shoppingcar1.R;
import com.bwie.huang.shoppingcar1.bean.ShopBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date:2017/12/19
 * time:14:11
 * author:HuangZhangpeng
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {
    private Context context;
    private List<ShopBean.DataBean.ListBean> list;
    private Map<String, String> map = new HashMap<>();

    public CarAdapter(Context context) {
        this.context = context;
    }

    public void add(ShopBean bean) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }

        for (ShopBean.DataBean shop : bean.getData()) {
            map.put(shop.getSellerid(), shop.getSellerName());
            for (int i = 0; i < shop.getList().size(); i++) {
                this.list.add(shop.getList().get(i));
            }
        }
        setFirst(this.list);
        notifyDataSetChanged();

    }

    /**
     * 为一级列表的checkbox和商家名添加flag
     *
     * @param list
     */
    private void setFirst(List<ShopBean.DataBean.ListBean> list) {
        if (list.size() > 0) {
            list.get(0).setIsFirst(1);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getSellerid() == list.get(i - 1).getSellerid()) {
                    list.get(i).setIsFirst(2);
                } else {
                    list.get(i).setIsFirst(1);
                }
            }
        }

    }

    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.car_item, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final CarAdapter.MyViewHolder holder, final int position) {
        if (list.get(position).getIsFirst() == 1) {
            holder.cbGroup.setVisibility(View.VISIBLE);
            holder.goupName.setVisibility(View.VISIBLE);
            holder.cbGroup.setChecked(list.get(position).isShopSelected());
            holder.goupName.setText(map.get(String.valueOf(list.get(position).getSellerid())));
        } else {
            holder.cbGroup.setVisibility(View.INVISIBLE);
            holder.goupName.setVisibility(View.INVISIBLE);
        }
        holder.price.setText(list.get(position).getPrice() + "");
        holder.title.setText(list.get(position).getTitle());
        holder.cbChild.setChecked(list.get(position).isItemSelected());
        String[] split = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(holder.img);
        holder.addAndDel.setEditText(list.get(position).getNum());
        holder.addAndDel.setListener(new AddAndDel.ClickListener() {
            @Override
            public void click(int count) {
                list.get(position).setNum(count);
                notifyDataSetChanged();
                sum(list);
            }
        });
        /**
         * 商家控制商品
         */
        holder.cbGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setShopSelected(holder.cbGroup.isChecked());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(position).getSellerid() == list.get(i).getSellerid()) {
                        list.get(i).setItemSelected(holder.cbGroup.isChecked());
                    }
                }
                sum(list);
                notifyDataSetChanged();
            }

        });
        /**
         * 商品控制商家
         */
         holder.cbChild.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 list.get(position).setItemSelected(holder.cbChild.isChecked());
                 for (int i = 0; i <list.size() ; i++) {
                     for (int j = 0; j <list.size() ; j++) {
                         if(list.get(i).getSellerid()==list.get(j).getSellerid()&&!list.get(j).isItemSelected()){
                             list.get(i).setShopSelected(false);
                             break;
                         }else{
                             list.get(i).setShopSelected(true);
                         }
                     }
                 }
                 sum(list);
                 notifyDataSetChanged();
             }
         });

        /**
         * 删除
         */
        holder.imdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                setFirst(list);
                sum(list);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox cbGroup;
        private final CheckBox cbChild;
        private final TextView title;
        private final TextView price;
        private final ImageView imdelete;
        private final ImageView img;
        private final TextView goupName;
        private final AddAndDel addAndDel;
        public MyViewHolder(View itemView) {
            super(itemView);
            cbGroup = itemView.findViewById(R.id.cb_group);
            cbChild = itemView.findViewById(R.id.cb_child);
            title = itemView.findViewById(R.id.tv_price);
            price = itemView.findViewById(R.id.tv_title);
            imdelete = itemView.findViewById(R.id.iv_del);
            img = itemView.findViewById(R.id.iv_img);
            goupName = itemView.findViewById(R.id.group_name);
            addAndDel=itemView.findViewById(R.id.addAndDel);
        }
    }

    /**
     * 全选与全不选
     */

     public void selectAll(boolean bool){
         for (int i = 0; i <list.size() ; i++) {
             list.get(i).setShopSelected(bool);
             list.get(i).setItemSelected(bool);
         }
         sum(list);
         notifyDataSetChanged();
     }
    /**
     * 计算总价
     */
   private void sum(List<ShopBean.DataBean.ListBean> list){
       int count=0;
       float price = 0.0f;
       boolean allcheck=true;
       for (int i = 0; i <list.size() ; i++) {
           if(list.get(i).isItemSelected()){
               count+=list.get(i).getNum();
               price+=list.get(i).getPrice()*list.get(i).getNum();
           }else{
               allcheck=false;
           }
       }
       listener.setTotal(price+"",count+"",allcheck);
   }
    private UpdateListener listener;
    public void setListener(UpdateListener listener){
        this.listener=listener;
    }
    public interface UpdateListener{
        void setTotal(String total,String num,boolean bool);
    }
}
