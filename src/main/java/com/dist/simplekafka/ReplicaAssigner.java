package com.dist.simplekafka;

import java.util.*;
import java.util.stream.Collectors;

public class ReplicaAssigner {
    final Random random;

    public ReplicaAssigner(Random random) {
        this.random = random;
    }

    public ReplicaAssigner() {
        this(new Random());
    }

    //brokerId,rack,dc
    public Set<PartitionReplicas> assignReplicasToBrokers(List<Integer> brokerList, int nPartitions, int replicationFactor) {
        //Implement assignment of replicas to brokers.
        return Collections.EMPTY_SET;
    }
}
