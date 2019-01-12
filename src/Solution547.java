class Solution547 {
  private int[] stu;

  public int findCircleNum(int[][] M) {
    int number = M.length;
    stu = new int[number];
    /* initialize */
    for (int i = 0; i < number; i++) {
      stu[i] = i;
    }
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        if (M[i][j] == 1) {
          union(i, j);
        }
      }
    }
    boolean[] result = new boolean[number];
    for (int i = 0; i < number; i++) {
      result[root(i)] = true;
    }

    int count = 0;
    for (int i = 0; i < number; i++) {
      if (result[i]) {
        count++;
      }
    }

    return count;
  }

  private int root(int i) {
    while (true) {
      if (i == stu[i]) {
        return i;
      }
      stu[i] = stu[stu[i]];
      i = stu[i];
    }
  }

  private boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  private void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (i == j) {
      return;
    }
    stu[i] = j;
  }
}
