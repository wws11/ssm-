package com.soecode.lyf.demo.test.io.nio.nio.demo.demo2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author 魏文思
 * @date 2019/11/21$ 8:57$
 */
public class Server {

    public static void main(String[] args) throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//2.切换到非堵塞模式
        serverSocketChannel.configureBlocking(false);
//3.绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(8080));
//4.获取选择器
        Selector selector = Selector.open();
//5.将通道注册到选择器上，并且指定“监听接收事件”
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//6轮询式的获取选择器上已经‘准备就绪’的事件
        while (selector.select() > 0) {
            //7 。获取当前选择器中所有注册的"选择健（已就绪的监听事件）"
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                //8.获取“准备就绪”的事件
                SelectionKey selectionKey = iterator.next();
                //9.判断具体事件，就绪
                if (selectionKey.isAcceptable()) {
                    //10.接收就绪，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11,切换到非堵塞模式
                    socketChannel.configureBlocking(false);
                    //12.将客户端通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //读取客户端传过来的数据
                    int len = 0;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }
                //取消选择键selectionKey
                iterator.remove();
            }
        }

    }
}
