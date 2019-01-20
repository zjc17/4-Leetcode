public class Solution979 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  static int result;
  public int distributeCoins(TreeNode root) {
    result = 0;
    postOrderTraverse(root);
    return result;
  }
  private void postOrderTraverse(TreeNode node) {
    if (node == null) {
      return;
    }
    postOrderTraverse(node.left);
    postOrderTraverse(node.right);
    if (node.left != null && node.left.val != 1) {
      int leftNeed = 1 - node.left.val;
      node.val -= leftNeed;
      result += Math.abs(leftNeed);
    }
    if (node.right != null && node.right.val != 1) {
      int rightNeed = 1 - node.right.val;
      node.val -= rightNeed;
      result += Math.abs(rightNeed);
    }
  }
}
