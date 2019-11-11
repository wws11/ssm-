package com.soecode.lyf.demo.zk.watcher;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @Description   测试zookeeper默认的watcher
 * @Author DJZ-WWS
 * @Date 2019/6/10 13:36
 */
public class DefaultWatcher  implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        System.out.println("==========DefaultWatcher start==============");

        System.out.println("DefaultWatcher state: " + event.getState().name());

        System.out.println("DefaultWatcher type: " + event.getType().name());

        System.out.println("DefaultWatcher path: " + event.getPath());

        System.out.println("==========DefaultWatcher end==============");

    }
}
