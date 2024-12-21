package com.dist.simplekafka;

import java.util.ArrayList;
import java.util.List;

public class ZkController {
    private final ZookeeperClient zookeeperClient;
    private final int brokerId;
    private int currentLeader = -1;
    private List<Broker> liveBrokers = new ArrayList<>();

    public ZkController(ZookeeperClient zookeeperClient, int brokerId) {
        this.zookeeperClient = zookeeperClient;
        this.brokerId = brokerId;
    }

    public void startup() {
        elect();
    }


    public void shutdown() {
        // Implementation not provided in the original code
    }

    public void elect() {
        //Implement this.
    }

    private void onBecomingLeader() {
        liveBrokers.addAll(zookeeperClient.getAllBrokers());
    }


    public int getCurrentLeaderId() {
        return currentLeader;
    }
}
