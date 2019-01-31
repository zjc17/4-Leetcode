public class Solution922 {
  public int[] sortArrayByParityII(int[] A) {
    int idx_even = 0;
    int idx_odd = 1;
    int length = A.length;
    while (idx_even < length && idx_odd < length) {
      while (idx_even < length && A[idx_even] % 2 == 0) {
        idx_even += 2;
      }
      while (idx_odd < length && A[idx_odd] % 2 == 1) {
        idx_odd += 2;
      }
      if (!(idx_even < length && idx_odd < length)) {
        break;
      }
      int tmp = A[idx_even];
      A[idx_even] = A[idx_odd];
      A[idx_odd] = tmp;
      idx_even += 2;
      idx_odd += 2;
    }
    return A;
  }
}
