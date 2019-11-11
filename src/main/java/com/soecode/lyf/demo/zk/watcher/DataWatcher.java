package com.soecode.lyf.demo.zk.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @Description  定义监听节点变化的watcher
 * @Author DJZ-WWS
 * @Date 2019/6/10 13:43
 */
public class DataWatcher  implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        System.out.println("==========DataWatcher start==============");

        System.out.println("DataWatcher state: " + event.getState().name());

        System.out.println("DataWatcher type: " + event.getType().name());

        System.out.println("DataWatcher path: " + event.getPath());

        System.out.println("==========DataWatcher end==============");

    }
}
