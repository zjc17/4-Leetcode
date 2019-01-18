import java.util.Arrays;

class Solution923 {
  public int threeSumMulti(int[] A, int target) {
    long result = 0;
    Arrays.sort(A);
    long[] numbers = new long[101]; // 0 <= A[i] <= 100
    for (int i: A) {
      numbers[i]++;
    }

    int min = 0;
    while (numbers[min] == 0) {
      min++;
    }
    int max = 100;
    while (numbers[max] == 0) {
      max--;
    }
    int i = min;
    while (i <= max) {
      int j = min;
      while (j <= max) {
        int key = target - i - j;
        if (key >= i && key <= j && numbers[key] > 0) {
          if (i == j && i != key) {
            result += (numbers[i] * (numbers[i] - 1) / 2) * numbers[key];
          } else if (i == key && i != j) {
            result += numbers[j] * ((numbers[i] - 1) * numbers[i] / 2);
          } else if (j == key && i != j) {
            result += numbers[i] * ((numbers[j] - 1) * numbers[j] / 2);
          } else if (i == j && j == key) {
            result += numbers[i] * (numbers[i] - 1) * (numbers[i] - 2) / 6;
          } else {
            result += numbers[i] * numbers[j] * numbers[key];
          }
        }
        do {
          j++;
        } while (j < max && numbers[j] == 0);
      }
      do {
        i++;
      } while (i < max && numbers[i] == 0);
    }
    return (int)(result % 1000000007);
  }
}