package com.bwie.huang.shoppingcar1.net;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by huang on 2017/11/21.
 */
public class OkhttpUtils {

    private static OkhttpUtils okhttpUtils = null;
    private static OkHttpClient client;
    private static HttpLoggingInterceptor logging;

    private OkhttpUtils(){
        logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    }
    public static OkhttpUtils getInstance(){
        if (okhttpUtils == null) {
            okhttpUtils = new OkhttpUtils();
            client = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .connectTimeout(20,TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .addInterceptor(new MyInterceptor())
                    .build();

        }
        return okhttpUtils;
    }

    public void  asy(Map<String,String> params,String url,OnUiCallback callback){
        Request request = null;
        if (params != null) {
            FormBody.Builder builder = new FormBody.Builder();
            for(Map.Entry<String,String> entry: params.entrySet()) {
                builder.add(entry.getKey(),entry.getValue());
            }
            FormBody body = builder.build();
            request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
        }else {
            request = new Request.Builder()
                    .url(url)
                    .build();
        }
        client.newCall(request).enqueue(callback);
    }

}
