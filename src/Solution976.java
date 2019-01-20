import java.util.Arrays;

public class Solution976 {

  public int largestPerimeter(int[] A) {
    Arrays.sort(A);
    // a > b > c
    int tmp = 0;
    int answer = 0;
    for (int i = 0, length = A.length - 2; i < length; i++) {
      tmp = A[i] + A[i + 1];
      if (tmp > A[i + 2]) {
        answer = tmp + A[i + 2];
      }
    }
    return answer;
  }
}
