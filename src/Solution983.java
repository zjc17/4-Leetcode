import java.util.HashSet;
import java.util.Set;

public class Solution983 {

  public int mincostTickets(int[] days, int[] costs) {
    int[] minCosts = new int[days[days.length - 1] + 1];
    Set<Integer> daySet = new HashSet<>();
    for (int day : days) {
      daySet.add(day);
    }
    int ticket1 = costs[0];
    int ticket7 = costs[1];
    int ticket30 = costs[2];
    for (int i = 1, length =  minCosts.length; i < length; i++) {
      if (!daySet.contains(i)) {
        minCosts[i] = minCosts[i - 1];
        continue;
      }
      minCosts[i] = getMinOfThree(
          minCosts[i - 1] + ticket1,
          minCosts[Math.max(0, i - 7)] + ticket7,
          minCosts[Math.max(0, i - 30)] + ticket30);
    }
    return minCosts[minCosts.length - 1];
  }

  private int getMinOfThree(int a, int b, int c) {
    int result = a < b ? a : b;
    if (c < result) {
      result = c;
    }
    return result;
  }
}
