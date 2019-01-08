import java.util.LinkedList;
import java.util.Queue;

public class Solution958 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode curNode;
    queue.offer(root);
    while (true) {
      curNode = queue.poll();
      if (curNode == null) {
        break;
      }
      queue.offer(curNode.left);
      queue.offer(curNode.right);
    }

    while (!queue.isEmpty()) {
      if (queue.poll() != null) {
        return false;
      }
    }
    return true;
  }

}
