import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution997 {

  public int findJudge(int N, int[][] trust) {
    boolean[] first = new boolean[N];
    for (int i = 0, length = trust.length; i < length; i++) {
      first[trust[i][0]-1] = true;
    }
    Map<Integer, Set<Integer>> res = new HashMap<>();
    for (int i = 0; i < N; i++) {
      if (!first[i]) {
        res.put(i + 1, new HashSet<>());
      }
    }
    for (int i = 0, length = trust.length; i < length; i++) {
      if (res.containsKey(trust[i][1])) {
        Set set = res.get(trust[i][1]);
        set.add(trust[i][0]);
      }
    }



    for (Map.Entry<Integer, Set<Integer>> entry : res.entrySet()) {
      if (entry.getValue().size() == N-1) {
        return entry.getKey();
      }
    }
    return -1;
  }
}
