public class Solution999 {

  public int numRookCaptures(char[][] board) {
    int res = 0;
    int i = 0, j = 0;
    boolean found = false;
    for (i = 0; i < 8 && !found; i++) {
      for (j = 0; j < 8 && !found; j++) {
        if (board[i][j] == 'R') {
          found = true;
        }
      }
    }
    int row,col;
    // up
    row = i;
    col = j;
    while (row > 0) {
      row--;
      if (board[row][col] == 'B') {
        break;
      }
      if (board[row][col] == 'p') {
        System.out.println("up");
        res++;
        break;
      }
    }
    i--;
    j--;
    // down
    row = i;
    col = j;
    while (row < 8) {
      row++;
      if (board[row][col] == 'B') {
        break;
      }
      if (board[row][col] == 'p') {
        System.out.println("down");
        res++;
        break;
      }
    }
    // left
    row = i;
    col = j;
    while (col > 0) {
      col--;
      if (board[row][col] == 'B') {
        break;
      }
      if (board[row][col] == 'p') {
        System.out.println("left");
        res++;
        break;
      }
    }
    // right
    row = i;
    col = j;
    while (col < 8) {
      col++;
      if (board[row][col] == 'B') {
        break;
      }
      if (board[row][col] == 'p') {
        System.out.println("right");
        res++;
        break;
      }
    }

    return res;
  }


  public static void main(String[] args) {
    char c = 'B';
    System.out.println(c == 'B');
  }
}
