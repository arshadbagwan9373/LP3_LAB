public class Practical4 {

    public static void main(String[] args) {

        // Profits and weights of items
        int profit[] = {60, 100, 120};
        int weight[] = {10, 20, 30};

        int capacity = 50;      // Maximum capacity of knapsack
        int n = 3;  // Number of items

        // DP table
        int dp[][] = new int[n + 1][capacity + 1];

        // Fill DP table
        for (int item_row = 0; item_row <= n; item_row++) {

            for (int capacity_colmn = 0; capacity_colmn <= capacity; capacity_colmn++) {

                // Base case: no item or no capacity
                if (item_row == 0 || capacity_colmn == 0) {
                    dp[item_row][capacity_colmn] = 0;
                }

                // If current item can fit in knapsack
                else if (weight[item_row - 1] <= capacity_colmn) {

                    // Maximum of:
                    // 1. Include current item
                    // 2. Exclude current item
                    dp[item_row][capacity_colmn] = Math.max(
                            profit[item_row - 1] + dp[item_row - 1][capacity_colmn - weight[item_row - 1]],
                            dp[item_row - 1][capacity_colmn]);
                }

                // Current item cannot fit
                else {
                    dp[item_row][capacity_colmn] = dp[item_row - 1][capacity_colmn];
                }
            }
        }

        // Final answer
        System.out.println("Maximum Profit = " + dp[n][capacity]);
    }
}