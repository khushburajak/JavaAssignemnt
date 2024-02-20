package Q1;

public class MinimumTimeToBuildEngines {
    public static int minTimeToBuildEngines(int[] engines, int splitCost) {
        int totalTime = 0;
        int numEngineers = 1;

        for (int i = engines.length - 1; i >= 0; i--) {
            int timeToBuild = engines[i];
            
            if (i == engines.length - 1) {
                totalTime += timeToBuild;
            } else {
                // Calculate the time if we split one engineer and assign them to build engines
                int timeIfSplit = Math.max(timeToBuild, splitCost + (engines[i] + 1) / 2);
                // Calculate the time if we don't split and assign the current engineer to build engines
                int timeIfNotSplit = totalTime + timeToBuild;
                // Choose the minimum time between splitting and not splitting
                totalTime = Math.min(timeIfSplit, timeIfNotSplit);
            }

            // Split one engineer into two
            numEngineers *= 2;
        }

        return totalTime;
    }

    public static void main(String[] args) {
        int[] engines = {1, 2, 3};
        int splitCost = 1;
        int minTime = minTimeToBuildEngines(engines, splitCost);
        System.out.println("Minimum time needed to build all engines: " + minTime);
    }
}