package com.soecode.lyf.demo.test.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * netty的客户端
 *
 * @author 魏文思
 * @date 2019/11/22$ 13:59$
 */
public class TimeClient {

    public void connect(int port, String host) throws Exception {
        //配置客户端线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //配置启动工具
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel channel)  {
                            channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            channel.pipeline().addLast(new StringDecoder());
                            channel.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            //发起异步连接操作
            ChannelFuture sync = bootstrap.connect(host, port).sync();
            //等待客户端链路关闭
            sync.channel().closeFuture().sync();
        } catch (Throwable e) {
            //Unable to create Channel from class class io.netty.channel.socket.nio.NioServerSocketChannel
            e.printStackTrace();
        } finally {
            //优雅退出，释放nio线程组
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        new TimeClient().connect(port, "127.0.0.1");
    }

}
