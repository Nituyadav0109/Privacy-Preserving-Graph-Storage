
package org.core;

import java.util.Set;

public class AnalyticsService {

    public static double averageDegree(PrivacyPreservingGraph graph) {
        return graph.snapshot().values()
                .stream()
                .mapToInt(Set::size)
                .average()
                .orElse(0);
    }
}
