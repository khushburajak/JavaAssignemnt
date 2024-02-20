package Q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

// Class representing an edge in the graph
class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Compare edges based on their weights
    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

// Class representing a disjoint set for union-find operations
class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // Find the parent of a node (with path compression)
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    // Union two sets by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

public class KruskalMST {
    public static List<Edge> kruskalMST(List<Edge> edges, int vertices) {
        // Sort the edges based on their weights
        Collections.sort(edges);

        List<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(vertices);

        for (Edge edge : edges) {
            int sourceParent = disjointSet.find(edge.source);
            int destinationParent = disjointSet.find(edge.destination);

            // Check if including this edge forms a cycle
            if (sourceParent != destinationParent) {
                minimumSpanningTree.add(edge);
                disjointSet.union(sourceParent, destinationParent);
            }
        }

        return minimumSpanningTree;
    }

    // Priority Queue implemented using a minimum heap
    static class PriorityQueueMinHeap<T extends Comparable<T>> {
        private List<T> heap;

        public PriorityQueueMinHeap() {
            heap = new ArrayList<>();
        }

        public void add(T element) {
            heap.add(element);
            int currentIndex = heap.size() - 1;
            int parentIndex = (currentIndex - 1) / 2;

            // Percolate up
            while (currentIndex > 0 && heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0) {
                Collections.swap(heap, currentIndex, parentIndex);
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }
        }

        public T poll() {
            if (isEmpty()) {
                throw new NoSuchElementException("Priority queue is empty");
            }

            T removedElement = heap.get(0);
            int lastIndex = heap.size() - 1;
            heap.set(0, heap.get(lastIndex));
            heap.remove(lastIndex);

            int currentIndex = 0;

            // Percolate down
            while (true) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                int minIndex = currentIndex;

                if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(minIndex)) < 0) {
                    minIndex = leftChildIndex;
                }

                if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(minIndex)) < 0) {
                    minIndex = rightChildIndex;
                }

                if (minIndex == currentIndex) {
                    break;
                }

                Collections.swap(heap, currentIndex, minIndex);
                currentIndex = minIndex;
            }

            return removedElement;
        }

        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Priority queue is empty");
            }
            return heap.get(0);
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public int size() {
            return heap.size();
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 7, 8));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 7, 11));
        edges.add(new Edge(2, 3, 7));
        edges.add(new Edge(2, 8, 2));
        edges.add(new Edge(2, 5, 4));
        edges.add(new Edge(3, 4, 9));
        edges.add(new Edge(3, 5, 14));
        edges.add(new Edge(4, 5, 10));
        edges.add(new Edge(5, 6, 2));
        edges.add(new Edge(6, 7, 1));
        edges.add(new Edge(6, 8, 6));
        edges.add(new Edge(7, 8, 7));

        List<Edge> mst = kruskalMST(edges, 9);

        System.out.println("Edges in the minimum spanning tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + ": " + edge.weight);
        }

        PriorityQueueMinHeap<Integer> pq = new PriorityQueueMinHeap<>();
        pq.add(3);
        pq.add(2);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        System.out.println("Priority queue (min heap):");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}