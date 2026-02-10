
# Privacy-Preserving Graph Storage

## Problem
Allow graph analytics without revealing sensitive node relationships.

## Overview
This project demonstrates a minimal, privacy-preserving graph storage design.
Node identities are anonymized, and direct access to node relationships
(neighbors, paths, traversal) is strictly prohibited.

Only aggregate and privacy-safe analytics are exposed.

## Key Design Principles
- Node identifiers are anonymized using deterministic hashing
- Edge relationships are never exposed externally
- Only aggregate analytics (e.g., degree counts, averages) are supported
- Thread-safe behavior validated using concurrent tests

## Project Structure
```
privacy-preserving-graph/
├── src/main/java/org/core/
│   ├── Graph.java
│   ├── PrivacyEncoder.java
│   ├── PrivacyPreservingGraph.java
│   ├── AnalyticsService.java
│   └── Demo.java
└── src/test/java/org/core/
    └── PrivacyPreservingGraphTest.java
```

## How to Run
### How to Compile
```
javac src/main/java/org/core/*.java
```

### Run Demo
```
java -cp src/main/java org.core.Demo
```

### Run Tests (Maven required)
```
mvn test
```

## Intentionally Unsupported Features
To preserve privacy guarantees, the following features are intentionally excluded:
- Neighbor listing
- Path traversal (BFS/DFS)
- Graph compression
- Edge inspection

These features are intentionally excluded to preserve privacy.

## Conclusion
This implementation enables useful graph analytics while ensuring
that sensitive node relationships are never exposed.
