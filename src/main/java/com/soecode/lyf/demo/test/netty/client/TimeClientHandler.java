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
    private int counter;
    byte[] req;

    public TimeClientHandler() {
        /**
         * System.getProperty("line.separator")  换行符，不区分linux和windows这么写更保险
         */
        req = ("QUERY TIME ORDER".getBytes() + System.getProperty("line.separator")).getBytes();
    }

    /**
     * 当客户端和服务端tcp链路建立连接之后，Netty的NIO线程会调用channelActive，
     * 发送查询时间的指令给服务端，调用ChannelhandlerContext的writeAndflush方法将请求消息发送给服务端
     *
     * @param ctx
     * @throws Exception
     */

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //循环发送一百条消息
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }

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
        //拿到的已经是解码之后的应答消息了
        String body = (String) msg;
        System.out.println("Now is :" + body + "；the counter is :" + ++counter);
    }

    /**
     * 当发生异常时，打印异常日志，释放客户端资源
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        log.warn("Unexceped exception from  downstream :" + cause.getMessage());
        String s = "";
        ctx.close();

    }

    public static void main(String[] args) {

    }

}
