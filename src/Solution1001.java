import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1001 {
  public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
    Set<Integer> sum = new HashSet<>(); // 左下到右上
    Set<Integer> sub = new HashSet<>(); // 左上到右下
    Set<Integer> row = new HashSet<>();
    Set<Integer> col = new HashSet<>();

    for (int[] lamp: lamps) {
      row.add(lamp[0]);
      col.add(lamp[1]);
      sum.add(lamp[0] + lamp[1]);
      sub.add(lamp[0] - lamp[1]);
    }

    int[] res = new int[queries.length];
    int idx = 0;
    for (int[] query: queries) {
      res[idx++] = query(query, row, col, sum, sub) ? 1 : 0;
      for (int[] lamp : lamps) {
        if (closeLamp(lamp, query)) {

        }
      }
    }
    return res;
  }

  private boolean closeLamp(int[] lamp, int[] query) {

  }

  private boolean query(int[] query, Set<Integer> sum,
      Set<Integer> sub, Set<Integer> row, Set<Integer> col) {
    if (sum.contains(query[0] + query[1])) {
      return true;
    }
    if (sub.contains(query[0] - query[1])) {
      return true;
    }
    if (row.contains(query[0])) {
      return true;
    }
    if (col.contains(query[1])) {
      return true;
    }

    return false;
  }
}
