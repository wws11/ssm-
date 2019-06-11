package com.soecode.lyf.tools.zk.watcher;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.TimeUnit;

public class WatcherTest {

    /**
     * 链接zk服务端的地址
     */
    private static final String CONNECT_STRING = "192.168.3.227:2181";

    public static void main(String[] args) {

        // 除了默认watcher外其他watcher一旦触发就会失效，需要充新注册，本示例中因为
        // 还未想到比较好的重新注册watcher方式(考虑到如果在Watcher中持有一个zk客户端的
        // 实例可能存在循环引用的问题)，因此暂不实现watcher失效后重新注册watcher的问题，
        // 后续可以查阅curator重新注册watcher的实现方法。

        // 默认watcher
        DefaultWatcher defaultWatcher = new DefaultWatcher();
        // 监听子节点变化的watcher
        ChildrenWatcher childrenWatcher = new ChildrenWatcher();
        // 监听节点数据变化的watcher
        DataWatcher dataWatcher = new DataWatcher();
        try {
            // 创建zk客户端，并注册默认watcher
            ZooKeeper zooKeeper = new ZooKeeper(CONNECT_STRING, 100000, defaultWatcher);

            // 让默认watcher监听 /GetChildren 节点的子节点变化
            // zooKeeper.getChildren("/GetChildren", true);

            // 让childrenWatcher监听 /GetChildren 节点的子节点变化(默认watcher不再监听该节点子节点变化)
            zooKeeper.getChildren("/GetChildren", childrenWatcher);

            // 让dataWatcher监听 /GetChildren 节点本省的变化(默认watcher不再监听该节点变化)
            zooKeeper.getData("/GetChildren", dataWatcher, null);

            TimeUnit.SECONDS.sleep(1000000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
