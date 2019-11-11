package com.soecode.lyf.demo.test.thread.documentconvert;

import java.util.List;

/**
 * @author 魏文思
 * @date 2019/10/12$ 17:05$
 */
public class MainThread {
    public static void main(String[] args) {
        //初始化数据的准备
        List<Document> documentList = DocumentServer.initDocumnet();
        for(int i=0;i<documentList.size();i++){
            Process process=new Process();
            process.setDocument(documentList.get(i));
            Thread thread = new Thread(process);
            thread.start();
        }
        System.out.println("主线程啊啊啊");
    }

}
