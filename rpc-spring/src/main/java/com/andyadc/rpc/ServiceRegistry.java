package com.andyadc.rpc;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author andaicheng
 * @version 2017/6/27
 */
public class ServiceRegistry {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceRegistry.class);

    private CountDownLatch latch = new CountDownLatch(1);

    private String registryAddress;

    public ServiceRegistry(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public void register(String data) {
        if (data != null) {
            ZooKeeper zk = connectServer();
            if (zk != null) {
                createNode(zk, data);
            }
        }
    }

    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(registryAddress, RpcConstant.ZK_SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        latch.countDown();
                    }
                }
            });
            latch.await();
        } catch (IOException | InterruptedException e) {
            LOG.error("connectServer error!", e);
        }
        return zk;
    }

    private void createNode(ZooKeeper zk, String data) {
        try {
            Stat stat = zk.exists(RpcConstant.ZK_REGISTRY_PATH, false);
            LOG.info("node '{}' exists, stat: {}", RpcConstant.ZK_REGISTRY_PATH, stat);
            if (stat != null) {
                zk.delete(RpcConstant.ZK_REGISTRY_PATH, stat.getVersion());
                LOG.info("delete node: '{}', version: {}", RpcConstant.ZK_REGISTRY_PATH, stat.getVersion());
            }

            zk.create(RpcConstant.ZK_REGISTRY_PATH, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            String path = zk.create(RpcConstant.ZK_DATA_PATH, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            LOG.info("create zookeeper node '{}' => '{}'", path, data);
        } catch (KeeperException | InterruptedException e) {
            LOG.error("createNode error!", e);
        }
    }
}
