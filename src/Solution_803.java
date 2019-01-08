class Solution_803 {
  private int sizeRow;
  private int sizeCol;
  private int top = 0;
  public int[] id;

  public int[] hitBricks(int[][] grid, int[][] hits) {
    final int[] result = new int[hits.length];
    sizeRow = grid.length;
    sizeCol = grid[0].length;
    top = sizeCol * sizeRow;
    int count = 0;

    for (int i = 0, nums = hits.length; i < nums; i++) {
      if (grid[hits[i][0]][hits[i][1]] == 0) {
        result[i] = 0;
        continue;
      } else {
        grid[hits[i][0]][hits[i][1]] = 0;
        count = 0;
      }

      /* change the grid[][] (hit the block), and initial the id[] */
      initial(grid);
      // System.out.println("id[0] = " + id[0]);
      /*// test
            // System.out.println("grid: ");
            // for (int row = 0; row < sizeRow; row++) {
            //   System.out.println(Arrays.toString(grid[row]));
            // }
            // System.out.println("id: " + Arrays.toString(id));
            // for (int row = 0; row < sizeRow; row++) {
            //   for (int col = 0; col < sizeCol; col++) {
            //     System.out.print(connected(row, col) + " ");
            //   }
            //   System.out.println();
            // }
            // System.out.println();
      */// test
      /* check if the grid is connected to the virtual top */
      for (int row = 0; row < sizeRow; row++) {
        for (int col = 0; col < sizeCol; col++) {
          if (grid[row][col] == 1 && !connected(row, col)) {
            grid[row][col] = 0;
            // System.out.printf("hit grid[%d][%d], and grid[%d][%d] falls.\n", hits[i][0], hits[i][1], row, col);
            count++;
          }
        }
      }
      /* store the result */
      result[i] = count;
    }

    return result;
  }

  /**
   * union all the grids and return their id. initial all the ids and then union all the grids.
   *
   * @return id after union
   */
  private void initial(int[][] grid) {
    id = new int[sizeCol * sizeRow + 1];
    /* initial the id array */
    for (int i = 0, length = id.length; i < length; i++) {
      id[i] = i;
    }

    /* Link tops grids with virtual top */
    for (int i = 0; i < sizeCol; i++) {
      if (grid[0][i] == 1) {
        // System.out.println("Root(i) is " + root(i) + ", root(top) = "+ root(top));
        // System.out.print("top " + i + " linked");
        union(i, top);
        // System.out.println(", id is " + id[i]);
        // System.out.println("Root(i) is " + root(i) + ", root(top) = "+ root(top));
      }
    }
    /* try to connect with adjacent grids */
    int current = 0;
    for (int row = 0; row < sizeRow; row++) {
      for (int col = 0; col < sizeCol; col++) {
        if (grid[row][col] == 1) {
          current = getIndex(row, col);
          if (row - 1 >= 0 && grid[row - 1][col] == 1) { // up
            union(current, current - sizeCol);
          }
          if (row + 1 < sizeRow && grid[row + 1][col] == 1) { //down
            union(current, current + sizeCol);
          }
          if (col - 1 >= 0 && grid[row][col - 1] == 1) { // left
            union(current, current - 1);
          }
          if (col + 1 < sizeCol && grid[row][col + 1] == 1) { // right
            union(current, current + 1);
          }
        }
      }
    }

  }

  private void union(int p, int q) {
    int pid = root(p);
    int qid = root(q);
    if (pid == qid) {
      return;
    }
    id[pid] = qid;
  }

  private boolean connected(int row, int col) {
    return root(getIndex(row, col)) == root(top);
  }

  private int getIndex(int row, int col) {
    return row * sizeCol + col;
  }

  private int root(int i) {
    while (i != id[i]) {
      /* path improvement */
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }
}