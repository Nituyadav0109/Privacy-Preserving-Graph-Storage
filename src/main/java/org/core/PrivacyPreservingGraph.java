
package org.core;

import java.util.*;

public class PrivacyPreservingGraph implements Graph {

    private final Map<Integer, Set<Integer>> internalGraph = new HashMap<>();

    public PrivacyPreservingGraph(Map<Integer, List<Integer>> rawGraph) {
        for (var entry : rawGraph.entrySet()) {
            int u = PrivacyEncoder.anonymize(entry.getKey());
            for (int vRaw : entry.getValue()) {
                int v = PrivacyEncoder.anonymize(vRaw);

                internalGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
                internalGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
            }
        }
    }

    @Override
    public int degree(int node) {
        int anon = PrivacyEncoder.anonymize(node);
        return internalGraph.getOrDefault(anon, Set.of()).size();
    }

    public int totalNodes() {
        return internalGraph.size();
    }

    Map<Integer, Set<Integer>> snapshot() {
        return internalGraph;
    }
}
