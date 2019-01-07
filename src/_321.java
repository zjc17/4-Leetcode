public class _321 {

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
      coins[i] = nums[i];
    }
    coins[length - 1] = 1;
    int[][] dp = new int[length][length];
    /* Initialized */
    for (int i = 2; i < length; i++) {
      for (int j = 0; j + i < length; j++) {
        for (int k = j + 1; k < j + i; k++) {
          dp[j][j + 1] = Math.max(dp[j][j + i],
              dp[j][k] + dp[k][j + i] + coins[j] * coins[k] * coins[j + i]);
        }
      }
    }
    return dp[0][length - 1];
  }
}
