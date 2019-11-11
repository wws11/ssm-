package com.soecode.lyf.demo.test.thread.documentconvert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 魏文思
 * @date 2019/10/12$ 17:08$
 */
public class DocumentServer {


    public static List<Document> initDocumnet() {
           List<Document> documents=new ArrayList<>();
            for(int i=0;i<5;i++){
                Document document=new Document();
                document.setDocumentName(i+"号文档");
                document.setSavePath(i+"dddddd");
                documents.add(document);
            }
            return documents;

    }
}
