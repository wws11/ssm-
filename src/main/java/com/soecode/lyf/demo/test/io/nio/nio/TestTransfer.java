package com.soecode.lyf.demo.test.io.nio.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author 魏文思
 * @date 2019/11/20$ 10:52$
 */
public class TestTransfer {

    @Test
    public   void  test01() throws IOException {
        RandomAccessFile fromFile =new RandomAccessFile("C:\\Users\\DELL\\Desktop\\测试文件\\niotest\\aaa.txt","rw");
        //获取fileChannel
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\测试文件\\niotest\\bbb.txt", "rw");
        FileChannel toChannel = toFile.getChannel();
        //定义传输位置
        long position=0L;
        //定义最多传输字节
        long count=fromChannel.size();
        //将数据从源通道传输到另一个通道
        fromChannel.transferTo(position,count,toChannel);
    }
    @Test
    public  void  testFrom() throws IOException {
        RandomAccessFile fromFile=new RandomAccessFile("C:\\Users\\DELL\\Desktop\\测试文件\\niotest\\bbb.txt","rw");
        FileChannel fromChannel = fromFile.getChannel();
       RandomAccessFile  toFile=new RandomAccessFile("C:\\Users\\DELL\\Desktop\\测试文件\\niotest\\aaa.txt","rw");
        FileChannel toChannel = toFile.getChannel();
        //定义传输位置
        long position=0L;
        //定义最多传输字节
        long count=fromChannel.size();
        toChannel.transferFrom(fromChannel,count,position);

    }

    @Test
    public  void  testSelector() throws IOException {
        //向选择器注册通道
        Socket socket = new Socket(InetAddress.getByName("192.168.3.93"), 9898);
        //获取socketChannel
        SocketChannel channel = socket.getChannel();
        //创建选择器
        Selector selector = Selector.open();
        //将SocketChannel切换到非阻塞模式
        channel.configureBlocking(false);
        //向Selector注册
        SelectionKey register = channel.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
    }

}
