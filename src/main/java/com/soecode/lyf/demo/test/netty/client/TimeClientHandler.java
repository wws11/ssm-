package com.soecode.lyf.demo.test.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 魏文思
 * @date 2019/11/22$ 14:07$
 */
@Slf4j
public class TimeClientHandler extends ChannelHandlerAdapter {
    private final ByteBuf firstMessage;

    public TimeClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);

    }

    /**
     * 当客户端和服务端tcp链路建立连接之后，Netty的NIO线程会调用channelActive，
     * 发送查询时间的指令给服务端，调用ChannelhandlerContext的writeAndflush方法将请求消息发送给服务端
     * @param ctx
     * @throws Exception
     */

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
        log.info("调用了 netty客户端处理器的适配器 的channelActive 方法");
    }

    /**
     * 当服务端返回应答消息时，channelRead方法被调用，将消息打印
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("Now is :" + body);
    }

    /**
     * 当发生异常时，打印异常日志，释放客户端资源
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught");
        //释放资源
        log.warn("Unexceped exception from  downstream :" + cause.getMessage());
        ctx.close();
    }
}
