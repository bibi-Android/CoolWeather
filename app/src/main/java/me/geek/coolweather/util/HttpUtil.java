package me.geek.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 通过OkHttp来获取服务器的数据工具类
 * @Author Geek-Lizc(394925542@qq.com)
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
