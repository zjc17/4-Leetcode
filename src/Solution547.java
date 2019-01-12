class Solution547 {
  private int[] stu;
  private int unions = 0;

  public int findCircleNum(int[][] M) {
    int number = M.length;
    stu = new int[number];
    /* initialize */
    for (int i = 0; i < number; i++) {
      stu[i] = i;
    }

    for (int i = 0; i < number; i++) {
      for (int j = i + 1; j < number; j++) { /* 如果有M[i][j] = 1，则有M[j][i] = 1。 */
        if (M[i][j] == 1) {
          union(i, j);
        }
      }
    }
    return number - unions;
  }

  private int root(int i) {
    while (true) {
      if (i == stu[i]) {
        return i;
      }
      stu[i] = stu[stu[i]]; /* path improvement */
      i = stu[i];
    }
  }

  private void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (i == j) {
      return;
    }
    stu[i] = j;
    unions++;
  }
}
