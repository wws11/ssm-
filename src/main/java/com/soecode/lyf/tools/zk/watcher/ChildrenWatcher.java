package com.soecode.lyf.tools.zk.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @Description  监听子节点变化的watcher
 * @Author DJZ-WWS
 * @Date 2019/6/10 13:42
 */
public class ChildrenWatcher  implements Watcher{
    @Override
    public void process(WatchedEvent event) {
        System.out.println("==========ChildrenWatcher start==============");

        System.out.println("ChildrenWatcher state: " + event.getState().name());

        System.out.println("ChildrenWatcher type: " + event.getType().name());

        System.out.println("ChildrenWatcher path: " + event.getPath());

        System.out.println("==========ChildrenWatcher end==============");


    }
}
