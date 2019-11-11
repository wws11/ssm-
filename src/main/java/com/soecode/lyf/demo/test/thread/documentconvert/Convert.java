package com.soecode.lyf.demo.test.thread.documentconvert;

/**
 * @author 魏文思
 * @date 2019/10/12$ 16:52$
 */
public class Convert  implements  Runnable {
    Document  doc;
    public   Document  getDoc(){
        return  doc;
    }
    public  void setDoc(Document doc){
        this.doc=doc;
    }
    @Override
    public void run() {
        //模拟长时间处理耗时操作
        System.out.println(doc.getDocumentName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doc.setSavePath(doc.getDocumentName()+"_path");
    }
}
