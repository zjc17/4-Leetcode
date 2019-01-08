public class Solution_312 {

  public int maxCoins(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    /* Dynamic Programming:
     *    subproblem -> four numbers, mid-two are available
     *        Final problem -> two numbers, with two 1 on the side
     *    for each problem, choose the smaller one.
     */

    /* Initial coins[] */
    int length = nums.length + 2;
    int[] coins = new int[length];
    coins[0] = 1;
    for (int i = 1, max_len = length - 1; i < max_len; i++) {
      coins[i] = nums[i - 1];
    }
    coins[length - 1] = 1;
    int[][] dp = new int[length][length];
    /* Initialized */
    int l; // left
    int r; // right
    for (int len = 2; len < length; len++) {
      for (l = 0; l + len < length; l++) {
        r = l + len;
        for (int k = l + 1; k < r; k++) {
          dp[l][r] = Math.max(dp[l][r],
              dp[l][k] + coins[l] * coins[k] * coins[r] + dp[k][r]);
        }
      }
    }
    return dp[0][length - 1];
  }
}
