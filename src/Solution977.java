import java.util.Arrays;

public class Solution977 {
  public int[] sortedSquares(int[] A) {
    int length = A.length;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = A[i] * A[i];
    }
    Arrays.sort(result);
    return result;
  }
}
