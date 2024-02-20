package Q5;

import java.util.*;

public class NetworkDeviceImpacts {
    public static List<Integer> findImpactedDevices(int[][] edges, int targetDevice) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> impactedDevices = new ArrayList<>();

        // Build adjacency list
        for (int[] edge : edges) {
            int device1 = edge[0];
            int device2 = edge[1];
            adjacencyList.putIfAbsent(device1, new ArrayList<>());
            adjacencyList.putIfAbsent(device2, new ArrayList<>());
            adjacencyList.get(device1).add(device2);
            adjacencyList.get(device2).add(device1);
        }

        // Perform DFS
        dfs(adjacencyList, targetDevice, visited, impactedDevices);

        return impactedDevices;
    }

    private static void dfs(Map<Integer, List<Integer>> adjacencyList, int currentDevice, Set<Integer> visited, List<Integer> impactedDevices) {
        visited.add(currentDevice);
        for (int neighbor : adjacencyList.getOrDefault(currentDevice, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                impactedDevices.add(neighbor);
                dfs(adjacencyList, neighbor, visited, impactedDevices);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 6}, {2, 4}, {4, 6}, {4, 5}, {5, 7}};
        int targetDevice = 4;
        List<Integer> impactedDevices = findImpactedDevices(edges, targetDevice);
        System.out.println("Impacted Device List: " + impactedDevices);
    }
}