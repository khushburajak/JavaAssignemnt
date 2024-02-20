package Q1;
public class MinimumCostDecoration {
    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;

        // dp[i][j] represents the minimum cost to decorate venues up to i
        // with the j-th theme where i-th venue is decorated with the j-th theme
        int[][] dp = new int[n][k];

        // Initialize the first row of dp with costs of decorating the first venue
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        // Iterate through venues starting from the second one
        for (int i = 1; i < n; i++) {
            // Iterate through themes for the current venue
            for (int j = 0; j < k; j++) {
                // Initialize minCost with the maximum possible value
                int minCost = Integer.MAX_VALUE;
                // Iterate through themes for the previous venue
                for (int prevTheme = 0; prevTheme < k; prevTheme++) {
                    // Skip the current theme if it's the same as the previous one
                    if (j != prevTheme) {
                        minCost = Math.min(minCost, dp[i - 1][prevTheme]);
                    }
                }
                // Update dp[i][j] with the minimum cost for the current venue and theme
                dp[i][j] = costs[i][j] + minCost;
            }
        }

        // Find the minimum cost among all possible ways to decorate the last venue
        int minTotalCost = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            minTotalCost = Math.min(minTotalCost, dp[n - 1][j]);
        }

        return minTotalCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{1, 3, 2}, {4, 6, 8}, {3, 1, 5}};
        int minCost = minCost(costs);
        System.out.println("Minimum cost to decorate all venues: " + minCost);
    }
}