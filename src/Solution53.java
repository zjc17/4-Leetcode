public class Solution53 {

  public int maxSubArray(int[] nums) {
    int res = nums[0];
    int sum = res;
    for (int i = 1, length = nums.length; i < length; i++) {
      if (sum > 0) {
        sum += nums[i];
      } else {
        sum = nums[i];
      }
      res = Math.max(res, sum);
    }
    return res;
  }
}
