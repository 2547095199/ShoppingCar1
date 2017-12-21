package com.bwie.huang.shoppingcar1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.huang.shoppingcar1.R;
import com.bwie.huang.shoppingcar1.adapter.OrderAdapter;
import com.bwie.huang.shoppingcar1.bean.OrderBean;
import com.bwie.huang.shoppingcar1.presenter.OrderPresenter;
import com.bwie.huang.shoppingcar1.view.OrderView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment implements OrderView{
List<OrderBean.DataBean> list=new ArrayList<>();
    private OrderPresenter presenter;
    private OrderAdapter adapter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_all2, container, false);
        RecyclerView recy= inflate.findViewById(R.id.recyclerView);
        presenter = new OrderPresenter(this);
        presenter.getData();
        recy.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapter = new OrderAdapter(getContext(),list);
        recy.setAdapter(adapter);

        return inflate;
    }

    @Override
    public void show(OrderBean bean) {
        list.addAll(bean.getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }
}
