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

     /**
     * Attempts to elect this broker as the controller in the Kafka cluster.
     * This method leverages ZooKeeper's strong consistency guarantees to ensure
     * only one controller exists at any time.
     * 
     * ZooKeeper's importance in controller election:
     * 1. Atomic Operations: ZooKeeper ensures the controller path creation is atomic
     *    (only one broker can succeed, even if multiple try simultaneously)
     * 2. Distributed Consensus: Using ZooKeeper's ZAB (ZooKeeper Atomic Broadcast) protocol,
     *    all servers in the ZooKeeper ensemble agree on the state of the controller
     * 3. High Availability: If the controller fails, ZooKeeper's watch mechanisms can
     *    notify other brokers to trigger a new election
     * 
     * Fault Tolerance in ZooKeeper:
     * - Quorum-based Updates: Changes are committed only when majority of ZooKeeper
     *   servers (2f+1 out of 2f+1 servers, where f is number of allowed failures) acknowledge
     * - Write Ahead Logging: Every state change is persisted to disk before acknowledging
     * - Failure Recovery: Even if some ZooKeeper servers fail, as long as a majority
     *   remains available, the controller election state is preserved
     * - Leader Election: ZooKeeper itself uses the ZAB protocol to elect its own leader,
     *   ensuring service continues even when some servers fail
     * 
     * Without a consensus system like ZooKeeper, distributed systems could end up in a
     * "split-brain" scenario where multiple nodes believe they are the controller,
     * leading to cluster inconsistencies.
     */
    public void elect() {
        //Implement election.
    }

    private void onBecomingLeader() {
        liveBrokers.addAll(zookeeperClient.getAllBrokers());
    }


    public int getCurrentLeaderId() {
        return currentLeader;
    }
}
