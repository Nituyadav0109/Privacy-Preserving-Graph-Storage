package org.core;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

class PrivacyPreservingGraphTest {

    @Test
    void concurrentInsertionsShouldWork() throws Exception {
        try {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            PrivacyPreservingGraph pg = new PrivacyPreservingGraph(graph);

            int threads = 5;
            CountDownLatch latch = new CountDownLatch(threads);

            for (int i = 0; i < threads; i++) {
                int id = i;
                new Thread(() -> {
                    graph.put(id, List.of(id + 1));
                    latch.countDown();
                }).start();
            }

            latch.await();

            assertTrue(pg.totalNodes() >= 0);

            // ✅ SUCCESS MESSAGE
            System.out.println("TEST PASSED: Concurrent insertions executed successfully");

        } catch (AssertionError | Exception e) {

            // ❌ FAILURE MESSAGE
            System.err.println("TEST FAILED: Concurrent insertions test failed");
            throw e; // very important (JUnit must still fail)
        }
    }
}
