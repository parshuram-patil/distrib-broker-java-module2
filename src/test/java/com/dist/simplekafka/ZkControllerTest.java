package com.dist.simplekafka;

import com.dist.common.ZookeeperTestHarness;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZkControllerTest extends ZookeeperTestHarness {
    @Test
    public void singleNodeBecomesController() {
        var broker = new Broker(config.getBrokerId(), config.getHostName(), config.getPort());
        zookeeperClient.registerBroker(broker); //this will happen together
        // with controller initialization on each node.

        ZkController zkController = new ZkController(zookeeperClient,
                config.getBrokerId());

        zkController.elect();

        assertEquals(config.getBrokerId(), zkController.getCurrentLeaderId());
    }


    @Test
    public void forMultipleNodesOnlyOneBecomesController() {
        var broker = new Broker(config.getBrokerId(), config.getHostName(), config.getPort());
        zookeeperClient.registerBroker(broker); //this will happen together
        // with controller initialization on each node.

        ZkController zkController1 = new ZkController(zookeeperClient, 1);
        ZkController zkController2 = new ZkController(zookeeperClient, 2);
        ZkController zkController3 = new ZkController(zookeeperClient, 3);

        zkController1.elect();
        zkController2.elect();
        zkController3.elect();

        assertEquals(1, zkController1.getCurrentLeaderId());
        assertEquals(1, zkController2.getCurrentLeaderId());
        assertEquals(1, zkController3.getCurrentLeaderId());
    }

}