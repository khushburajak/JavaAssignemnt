package Q4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MazeSolver {
    public static int shortestPathToCollectAllKeys(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        // Find the starting position and initialize BFS
        Queue<int[]> queue = new LinkedList<>();
        Set<Character> keys = new HashSet<>();
        int[] start = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    start = new int[]{i, j, 0}; // Format: {row, column, steps}
                    queue.offer(start);
                }
            }
        }

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];
            char cell = grid[row][col];

            if (keys.size() == 26) { // All keys collected
                return steps;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] != 'W') {
                    char nextCell = grid[newRow][newCol];
                    if (nextCell == 'P' || nextCell == 'S' || Character.isLowerCase(nextCell) || keys.contains(Character.toLowerCase(nextCell))) {
                        if (Character.isLowerCase(nextCell)) {
                            keys.add(nextCell);
                        } else if (Character.isUpperCase(nextCell) && !keys.contains(Character.toLowerCase(nextCell))) {
                            continue; // Door without the key
                        }
                        queue.offer(new int[]{newRow, newCol, steps + 1});
                    }
                }
            }
        }

        // Cannot collect all keys
        return -1;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'S', 'P', 'q', 'P', 'P'},
            {'W', 'W', 'W', 'P', 'W'},
            {'r', 'P', 'Q', 'P', 'R'}
        };
        int minSteps = shortestPathToCollectAllKeys(grid);
        System.out.println("Minimum steps to collect all keys: " + minSteps);
    }
}