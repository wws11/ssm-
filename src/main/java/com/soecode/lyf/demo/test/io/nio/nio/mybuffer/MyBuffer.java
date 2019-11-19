package com.soecode.lyf.demo.test.io.nio.nio.mybuffer;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 魏文思
 * @date 2019/11/18$ 20:32$
 */
public class MyBuffer {


    /**
     * 当向buffer写入数据的的时候，buffer会记录写下来多少数据。一旦要读取数据，
     * 需要通过调用flip（）方法将Buffer从读的模式切换到写的模式。
     * 在读的模式之下，可以读取之前写入到buffer的所有数据。
     * 一旦读完了所有的数据就需要清空缓冲区，让他可以再次被写入。
     * 有两种方法能够清空缓冲区：调用clear方法或者compact（）
     * clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
     */
    @Test
    public void test1() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\登录信息.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
//create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf); //read into buffer.
        while (bytesRead != -1) {
            buf.flip();  //make buffer ready for read
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get()); // read 1 byte at a time

            }
            buf.clear(); //make buffer ready for writing

            bytesRead = inChannel.read(buf);

        }

        aFile.close();

    }
}
