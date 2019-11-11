package com.soecode.lyf.demo.test.thread.heaptest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 魏文思
 * @date 2019/10/23$ 9:29$
 */
public class OOMObject {

    public byte[] placceholder = new byte[64 * 1024];

    public static void fileHeap(int num) throws Exception {
        List<OOMObject> list = new ArrayList<>();
     /*   for (int i = 0; i < num; i++) {
      qps
        }*/
     while (true){
         Thread.sleep(50);
         list.add(new OOMObject());
     }
       // System.gc();
    }

    public static void main(String[] args) throws Exception {
        fileHeap(1000);
    }
}
