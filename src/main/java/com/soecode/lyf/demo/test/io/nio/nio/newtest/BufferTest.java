package com.soecode.lyf.demo.test.io.nio.nio.newtest;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * @author 魏文思
 * @date 2019/11/21$ 11:15$
 */
public class BufferTest {

    /**
     * 使用Buffer读取和写入数据遵循原则：
     * 1.将数据写入缓冲区
     * 2.调用buffer.flip()  切换模式
     * 3.从缓冲区读取数据
     * 4.清空缓冲区调用buffer.clear()或者buffer.compact()
     * * * /
     */
    /**
     * 实现功能：将数据写入缓存区
     * @throws IOException
     */
    @Test
    public void testBuffer() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\测试文件\\niotest\\bbb.txt", "rw");
        FileChannel channel = accessFile.getChannel();
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读入缓冲区
        int read = channel.read(buffer);
        while (read != -1) {
            //准备读取缓冲区
            System.out.println(buffer.position());
            System.out.println(buffer.limit());
            System.out.println(buffer.capacity());
            buffer.flip();
            while (buffer.hasRemaining()) {
                //一次读取一个字节
                System.out.println((char) buffer.get());
            }
            //准备写入缓冲区
            channel.read(buffer);
        }
        accessFile.close();
    }

    /*
    通道 和通道之间的数据传递  transfrom
     */
    @Test
    public void testTransferFrom() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\微信图片_20191118132925.jpg", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\aaa.jpg", "rw");
        FileChannel toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel, position, count);
    }

    /**
     * transferTo  从一个通道
     */

    @Test
    public void testTranferTo() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        fromChannel.transferTo(position, count, toChannel);
    }

    @Test
    public void TestSelector() throws IOException {
        Selector selector = Selector.open();

    }
}
