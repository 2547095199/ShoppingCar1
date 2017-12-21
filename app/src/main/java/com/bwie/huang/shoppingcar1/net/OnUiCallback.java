package com.bwie.huang.shoppingcar1.net;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by huang on 2017/11/21.
 */
public abstract class OnUiCallback<T> implements Callback {
    public Handler handler = null;
    private Class clazz;
    public OnUiCallback(){
        handler = new Handler(Looper.getMainLooper());

        Type type = getClass().getGenericSuperclass();
        Type[] arr = ((ParameterizedType)type).getActualTypeArguments();
        clazz = (Class)arr[0];

      }

     public  abstract void success(T t);
     public  abstract void  failure(Exception e);






    @Override
    public void onFailure(Call call, IOException e) {
        failure(e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
          String result = response.body().string();
          Gson gson = new Gson();
          final  T t = (T)gson.fromJson(result,clazz);
          handler.post(new Runnable() {
              @Override
              public void run() {
                  success(t);
              }
          });



    }
}
