package com.soecode.lyf.demo.test.thread.documentconvert;

/**
 * 请求处理线程类（A线程），该类启动文档转换线程，并调用sleep方法自身休眠1000毫秒，等待文档转换工作的完成。
 *
 * @author 魏文思
 * @date 2019/10/12$ 16:58$
 */
public class Process implements  Runnable {
    Document document;
    public   Document document(){
        return  document;
    }
    public void  setDocument(Document document){
        this.document=document;
    }

    @Override
    public void run() {
        Convert convert=new Convert();
        convert.setDoc(document);
        Thread thread=new Thread(convert);
        thread.start();
        while (true){
            try {

                Thread.sleep(1000);
                if(!document.getSavePath().equals("")){
                    System.out.println(document.getDocumentName()+"处理完成，存储路径为："+document.getSavePath());
                    return;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //集合，IO，多线程，数据结构
}
