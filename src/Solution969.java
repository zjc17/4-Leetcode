import java.util.LinkedList;
import java.util.List;

class Solution969 {

  public List<Integer> pancakeSort(int[] A) {
    List<Integer> result = new LinkedList<>();
    int curIdx = A.length;
    while (curIdx > 0) {
      int maxId = 0;
      for (int i = 0; i < curIdx; i++) {
        if (A[i] == curIdx) {
          maxId = i;
          break;
        }
      }
      if (maxId > 0) {
        result.add(maxId + 1);
        reverse(A, maxId + 1);
      }
      result.add(curIdx);
      reverse(A, curIdx);
      curIdx--;
    }
    return result;
  }

  private void reverse(int[] A, int idx) {
    int i = 0;
    int j = idx - 1;
    while (i < j) {
      A[i] = A[i] ^ A[j];
      A[j] = A[i] ^ A[j];
      A[i] = A[i] ^ A[j];
      i++;
      j--;
    }
  }
}
