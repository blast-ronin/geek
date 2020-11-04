package io.nanfeng;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

/**
 * @author nanfeng
 * @date 2020/10/28 6:09 下午
 */
public class OkHttpTest {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8081")
                .get()
                .build();
        try (var rep = client.newCall(request).execute()) {
            String result = rep.body().string();
            System.out.println("result = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
