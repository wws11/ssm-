package com.soecode.lyf.demo.test.netty.server;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * Netty时间服务器服务端
 * <p>
 * 主要用于对网络事件进行读写操作，
 * 通常我们只关心channelRead和exceptionCaught方法。
 *
 * @author 魏文思
 * @date 2019/11/22$ 10:06$
 */
public class TimeServerHandler extends ChannelHandlerAdapter {
    private  int  counter;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        /**
         * 将msg转换成了Netty的ByteBuf对象。Bytebuf类似于jdk中的Java.nio.ByteBuffer对象，不过他提供 了更加强大和灵活的功能。
         * 通过ByteBuf的readablebytes方法可以获取缓冲区可读取的字节数，根据可读的字节数创建byte数组，通过ByteBuf的readBytes方法可以获取缓冲区可读的字节数，
         * 根据可读的字节数创建byte数组，通过Bytebuf的readBytes方法将缓冲区中的字节数组复制到新建的byte数组中，最后通过new String的构造函数获取请求消息。
         * 这时对请求消息进行判断，如果是QUERY TIME ORDER 则创建应答消息，通过ChannelHandlerContent的write方法异步发送应答消息给客户端。
         */
        String body = (String) msg;
        /**
         * 解决粘包拆包问题，每读到一条消息，就统计一次，然后发送应答消息给客户端。服务端客户端接收到的消息一致
         */
        System.out.println("the  time server receive order ;" + body+"the counter is :"+ ++counter);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        currentTime=currentTime+System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        /**
         * 调用flush（）方法它的作用是将消息发送队列中的消息写入到SocketChannel中发送给对方。
         * 从性能角度考虑，为了防止频繁你唤醒Selector进行消息发送，Netty的write方法并不直接将消息写入SocketChannel中,调用write方法只是把待发送的消息发送到缓存数组中，
         * 再通过调用flush方法，将发送缓存区中的消息全部写道Socketchannel中。
         *
         * 这种涉及思想在批量插入数据库的有类似操作。提高性能
         *
         */
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        /**
         * 当发生异常时，关闭ChannelHandlerContext，释放和ChannelhanlerContext相关联的句柄资源。
         */
        ctx.close();
    }
}
