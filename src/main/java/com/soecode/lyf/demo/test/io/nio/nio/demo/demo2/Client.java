package com.soecode.lyf.demo.test.io.nio.nio.demo.demo2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author 魏文思
 * @date 2019/11/21$ 8:57$
 */
public class Client {

    public static void main(String[] args) throws IOException {
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
       //2.设置为非堵塞模式
        socketChannel.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.allocate(1024);
       //3.发送数据给服务端
       //控制台输入数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String msg = scanner.next();
            buf.put(msg.getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }
//4.关闭连接
        socketChannel.close();
    }
}
