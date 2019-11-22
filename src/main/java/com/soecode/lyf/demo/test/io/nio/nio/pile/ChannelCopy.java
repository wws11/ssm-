package com.soecode.lyf.demo.test.io.nio.nio.pile;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 实现从一个通道到复制数据到另一个通道
 *
 * @author 魏文思
 * @date 2019/11/18$ 20:05$
 */
public class ChannelCopy {


    public static void main(String[] args) throws IOException {

        ReadableByteChannel source = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);
        channelCopy2(source, dest);
        source.close();
        dest.close();
    }

    public static void channelCopy1(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(buffer) != -1) {
            //准备缓冲区
            buffer.flip();
            dest.write(buffer);
            //compact方法 把buffer中内部数组剩余未读取的数据复制到该数组从索引为0开始，
            // 然后position设置为复制剩余数据后的最后一位元素的索引+1，limit设置为capcity，此时0-position
            //之间是未读数据，而position-limit之间是buffer的剩余空间，可以put数据。
            buffer.compact();
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            dest.write(buffer);
        }
    }

    private static void channelCopy2(ReadableByteChannel src,
                                     WritableByteChannel dest)
            throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(buffer) != -1) {
// Prepare the buffer to be drained
            buffer.flip();
// Make sure that the buffer was fully drained
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
// Make the buffer empty, ready for filling
            buffer.clear();
        }
    }

    @Test
    public void testPipe() throws IOException {
        String str = "测试数据";
        //创建管道
        Pipe pipe = Pipe.open();
        //向管道写输入
        Pipe.SinkChannel sink = pipe.sink();
        //通过 SinkChannel的write（）方法写数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        buffer.put(str.getBytes());
        buffer.flip();
        while (buffer.hasRemaining()){
            sink.write(buffer);
        }
    }

    @Test
    public   void  test2() throws IOException {
        //创建管道
        Pipe pipe = Pipe.open();
        Pipe.SourceChannel source = pipe.source();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        source.read(buffer);

    }

}
