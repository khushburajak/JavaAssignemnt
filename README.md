# Java Algorithms and Data Structures

This repository contains Java implementations of various algorithms and data structures. for each question the logic is described below.
## MinimumCostDecoration

- **Description:** Dynamic programming solution to find the minimum cost to decorate venues with different themes.
- **Implementation:**
  - Iterate through venues and themes, considering the minimum cost of the previous venue for different themes.
  - Find the minimum total cost among all possible ways to decorate the last venue.

## MinimumTimeToBuildEngines

- **Description:** Greedy approach to calculate the minimum time needed to build engines.
- **Implementation:**
  - Consider splitting one engineer into two and assign them to build engines based on time comparisons.
  - Choose the minimum time between splitting and not splitting at each step.

## EqualizeDresses

- **Description:** Java solution to calculate the minimum moves required to equalize the number of dresses among machines.
- **Implementation:**
  - Determine the target number of dresses for each machine based on the total dresses and the number of machines.
  - Iterate through machines, updating moves and tracking the maximum difference.

## SecretSharing

- **Description:** Simulation of secret sharing among individuals within given time intervals in Java.
- **Implementation:**
  - Use a set to store individuals who received the secret, considering the cyclic nature of sharing.
  - Convert the set to a list and sort it to get the final list of individuals who eventually knew the secret.

## ScoreTracker

- **Description:** Java class using two heaps (min heap and max heap) to efficiently calculate the median of a stream of scores.
- **Implementation:**
  - Balance the heaps to ensure efficient retrieval of the median.

## KruskalMST

- **Description:** Java implementation of Kruskal's algorithm to find the minimum spanning tree (MST) of a graph.
- **Implementation:**
  - Utilize a priority queue (min heap) for efficient edge selection.
  - Implement a disjoint set for union-find operations to detect and avoid cycles.

## MazeSolver

- **Description:** Solve the maze problem using BFS in Java.
- **Implementation:**
  - Find the starting position and explore possible moves, considering walls, keys, and doors.
  - Update the position and keys collected during traversal.

## ClosestValuesInBST

- **Description:** Java program to find the k closest values to a target value in a Binary Search Tree (BST).
- **Implementation:**
  - Use inorder traversal to calculate the differences between node values and the target.
  - Utilize a priority queue to efficiently track the k closest values.

## AntColonyTSP

- **Description:** Apply Ant Colony Optimization to solve the Traveling Salesman Problem (TSP) in Java.
- **Implementation:**
  - Construct solutions iteratively by ants, considering pheromone levels and heuristic information.
  - Update pheromone levels based on evaporation and pheromone deposit.

## NetworkDeviceImpacts

- **Description:** Use Depth-First Search (DFS) in Java to find devices impacted by a target device in a network.
- **Implementation:**
  - Build an adjacency list representing the network.
  - Perform DFS traversal, marking visited devices, and adding impacted devices to the list.
