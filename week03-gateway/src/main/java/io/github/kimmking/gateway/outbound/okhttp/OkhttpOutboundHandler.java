package io.github.kimmking.gateway.outbound.okhttp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class OkhttpOutboundHandler {
    private final OkHttpClient client = new OkHttpClient();

    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
        HttpHeaders headers = fullRequest.headers();
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
