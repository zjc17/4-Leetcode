public class Solution998 {
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    if (val > root.val) {
      TreeNode tmp = new TreeNode(val);
      tmp.left = root;
      root = tmp;
      return root;
    } else {
      insert(root, val);
      return root;
    }
  }

  private void insert(TreeNode root, int val) {
    if (val > root.val) {
      TreeNode tmp = new TreeNode(val);
      tmp.left = root;
      root = tmp;
    } else if (root.right == null || val > root.right.val) {
      TreeNode tmp = new TreeNode(val);
      tmp.left = root.right;
      root.right = tmp;
    } else if (root.left != null && val > root.left.val) {
      insert(root.right, val);
    } else if (root.left == null) {
      TreeNode tmp = new TreeNode(val);
      root.left = tmp;
    } else {
      insert(root.left, val);
    }
  }
}
