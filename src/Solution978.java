public class Solution978 {
  public int maxTurbulenceSize(int[] A) {
    int length = A.length;
    if (length == 1) {
      return 1;
    } else if (length == 2) {
      return A[0] == A[1] ? 1 : 2;
    }

    int lastCOmpare = Integer.compare(A[0], A[1]);
    int presentCompare;
    int maxLength = 0;
    int curLength = lastCOmpare == 0 ? 1 : 2;
    for (int i = 1, len = length - 1; i < len; i++) {
      presentCompare = Integer.compare(A[i], A[i+1]);
      // System.out.println("i = " + i + " lastCOmpare = " + lastCOmpare + " presentCompare = " + presentCompare);
      if (lastCOmpare == 0) {
        lastCOmpare = presentCompare;
        curLength = lastCOmpare == 0 ? 1 : 2;
        continue;
      } else if (presentCompare == 0) {
        lastCOmpare = presentCompare;
        if (curLength > maxLength) {
          maxLength = curLength;
        }
        curLength = 1;
      } else if (Math.abs(presentCompare + lastCOmpare) == 2) {
        lastCOmpare = presentCompare;
        if (curLength > maxLength) {
          maxLength = curLength;
        }
        curLength = 2;
      } else {
        lastCOmpare = presentCompare;
        curLength++;
        // System.out.println("+");
      }
    }
    if (curLength > maxLength) {
      maxLength = curLength;
    }
    return maxLength;
  }

}
