
// package org.core;

// import java.util.*;

// public class Demo {

//     public static void main(String[] args) {

//         Map<Integer, List<Integer>> graph = new HashMap<>();
//         graph.put(1, List.of(2, 3, 4));
//         graph.put(2, List.of(3, 5));
//         graph.put(3, List.of(5));
//         graph.put(4, List.of(5));
//         graph.put(5, List.of());

//         PrivacyPreservingGraph pg = new PrivacyPreservingGraph(graph);

//         Scanner scanner = new Scanner(System.in);
//         while (true) {
//             System.out.print("Enter node to query degree (-1 to exit): ");
//             int node = scanner.nextInt();
//             if (node == -1) break;
//             System.out.println("Privacy-safe degree = " + pg.degree(node));
//         }

//         System.out.println("Average Degree = " +
//                 AnalyticsService.averageDegree(pg));
//         scanner.close();
//     }
// }

package org.core;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2, 3, 4));
        graph.put(2, List.of(3, 5));
        graph.put(3, List.of(5));
        graph.put(4, List.of(5));
        graph.put(5, List.of());

        PrivacyPreservingGraph pg = new PrivacyPreservingGraph(graph);

        Scanner scanner = new Scanner(System.in);

        // Interactive degree query
        while (true) {
            System.out.print("Enter node to query degree (-1 to exit): ");
            int node = scanner.nextInt();

            if (node == -1) {
                break;
            }

            System.out.println("Privacy-safe degree = " + pg.degree(node));
        }

        // ✅ Privacy-safe aggregate information
        System.out.println("\nTotal nodes in graph (privacy-safe) = " + pg.totalNodes());

        System.out.println("Average Degree (privacy-safe) = " +
                AnalyticsService.averageDegree(pg));

        scanner.close();
    }
}
