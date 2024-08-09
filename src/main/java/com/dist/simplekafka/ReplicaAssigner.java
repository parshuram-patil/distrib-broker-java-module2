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

    public Set<PartitionReplicas> assignReplicasToBrokers(List<Integer> brokerList, int nPartitions, int replicationFactor) {
        //Assignment4 - Implement this method to fulfill all the tests. Hint.
        // Use Claude or Chatgpt :-)
        return Collections.emptySet();
    }
}
