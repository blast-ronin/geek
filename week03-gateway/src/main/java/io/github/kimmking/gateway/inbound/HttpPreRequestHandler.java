package io.github.kimmking.gateway.inbound;

import io.github.kimmking.gateway.filter.DefaultHttpRequestFilter;
import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * @author nanfeng
 * @date 2020/11/3 7:50 下午
 */
public class HttpPreRequestHandler extends ChannelInboundHandlerAdapter {
    private final List<HttpRequestFilter> filters;

    public HttpPreRequestHandler() {
        List<HttpRequestFilter> filters = ServiceLoader.load(HttpRequestFilter.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        filters.add(0, new DefaultHttpRequestFilter());
        this.filters = filters;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            FullHttpRequest httpRequest = (FullHttpRequest) msg;
            this.filters.forEach(f -> f.filter(httpRequest, ctx));
        } catch (Throwable throwable) {
            ReferenceCountUtil.release(msg);
        }
    }
}
