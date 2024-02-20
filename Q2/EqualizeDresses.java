package Q2;
public class EqualizeDresses {
    public static int minMovesToEqualize(int[] machines) {
        int totalDresses = 0;
        int n = machines.length;

        // Step 1: Calculate total number of dresses
        for (int machine : machines) {
            totalDresses += machine;
        }

        // Step 2: Calculate target number of dresses for each machine
        if (totalDresses % n != 0) {
            return -1; // If total dresses cannot be evenly distributed, return -1
        }
        int target = totalDresses / n;

        // Step 3 & 4: Calculate the minimum moves required to equalize dresses
        int moves = 0;
        int dressesDiff = 0;
        for (int dresses : machines) {
            dressesDiff += dresses - target;
            moves = Math.max(moves, Math.max(Math.abs(dressesDiff), dresses - target));
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] machines = {1, 0, 5};
        int minMoves = minMovesToEqualize(machines);
        System.out.println("Minimum moves required to equalize dresses: " + minMoves);
    }
}