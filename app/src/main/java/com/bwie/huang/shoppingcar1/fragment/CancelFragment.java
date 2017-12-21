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
public class CancelFragment extends Fragment implements OrderView{

    private OrderPresenter presenter;
    private List<OrderBean.DataBean>  list = new ArrayList<>();
    private OrderAdapter adapter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_cancel, container, false);
       RecyclerView recy_cancel=view.findViewById(R.id.recy_cancel);
        presenter = new OrderPresenter(this);
        presenter.getSortData("2");
        adapter = new OrderAdapter(getContext(),list);
        recy_cancel.setAdapter(adapter);
        recy_cancel.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return view;
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
