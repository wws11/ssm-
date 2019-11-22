package com.soecode.lyf.demo.test.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author 魏文思
 * @date 2019/11/22$ 9:48$
 */
public class TimeServer {

    public void bind(int port) throws Exception {
        //配置服务端的nio线程组
        /**
         * NioEventLoopGroup 是个线程组，它包含了一组nio线程，专门用于服务端接受客户端网络事件的处理，
         * 实际上他们呢就是Reactor线程组。创建两个的原因一个是用于服务端接受客户端的连接，另一个用于进行SocketChannel的网络读写。
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            /**
             * Serverboostrap是netty用于启动服务辅助启动类，目的是降低服务端的开发复杂度。
             */
            ServerBootstrap b = new ServerBootstrap();
            /**
             * 调用group方法，将两个nio线程组当作传入参数传递到ServcerbootStrap中。
             * 接着设置创建的Channel为NioServerSocketChannel，他的功能对应于JDK nio类库中的ServerSocketChannel类。
             * 然后配置NioServerSocketChannel的tcp参数，此处将他的backlog设置为1024，
             * 最后绑定IO事件的处理类childrenChannelHandler，他的作用类似于Reactor模式中Handler类，主要用于从处理网络IO事件，例如记录日志，对消息进行编码
             */
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHanler());
            //绑定客户端，同步等待成功
            /**
             * 服务端启动辅助类配置完成之后，调用它的bind方法绑定监听器端口，
             * 随后调用它的 同步阻塞方法sync等到绑定操作完成。
             * 完成之后Netty会返回一个ChannelFuture，它的功能类似于jdkjdk current 包里面的Future,主要用于异步操作的通知回调。
             */
            ChannelFuture f = b.bind(port).sync();
            //等待服务端监听
            // 端口关闭
            /**
             * 调用f.channel().closeFuture().sync()来进行阻塞，等待服务端链路关闭之后main函数才退出
             */
            System.out.println("1");
            f.channel().closeFuture().sync();
            System.out.println("2");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            //优雅退出
            /**
             * 它会释放跟踪shutdownGracefully相关联的资源。
             */
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    //IO事件处理器 用于异步操作的通知回调
    private class ChildChannelHanler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                Integer post = Integer.valueOf(args[0]);
            } catch (Exception e) {
                //采用默认值
                e.printStackTrace();
            }
        }
        new TimeServer().bind(port);

    }
}
