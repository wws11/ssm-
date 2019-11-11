package com.soecode.lyf.demo.test.jacob;

/**
 * @author 魏文思
 * @date 2019/10/15$ 11:29$
 */
public class MyTest {

    public static void main(String[] args) {
        boolean wordFlag =false;
        boolean pptFlag = true;
       if(wordFlag||pptFlag){
           System.out.println("bbb");
       }
        if (!wordFlag && !pptFlag) {
            System.out.println("ddddd");
        }
        System.out.println("aaa");
    }
}
