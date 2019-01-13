import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution973 {
  class Node{
    int distance;
    int index;
    public Node(int d, int i) {
      this.distance = d;
      this.index = i;
    }
  }
  public int[][] kClosest(int[][] points, int K) {
    int numbers = points.length;
    Queue<Node> priorityQueue = new PriorityQueue<Node>(numbers, new Comparator<Node>() {
      public int compare(Node I1, Node I2) {
        return I1.distance - I2.distance;
      }
    });

    for (int i = 0; i < numbers; i++) {
      priorityQueue.add(new Node(points[i][0]*points[i][0] + points[i][1]*points[i][1], i));
    }

    int index = 0;
    int[][] result = new int[K][2];
    for (int i = 0; i < K; i++) {
      index = priorityQueue.poll().index;
      result[i][0] = points[index][0];
      result[i][1] = points[index][1];
    }
    return result;
  }
}