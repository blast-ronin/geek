package io.nanfeng;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://localhost:8081")
                .get()
                .build();
       try ( Response rep=client.newCall(request).execute()){
           String result = rep.body().string();
           System.out.println("result = " + result);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
