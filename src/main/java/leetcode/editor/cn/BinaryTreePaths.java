  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;
  import model.TreeNode;

  /**
   * [257] 二叉树的所有路径
   */
  public class BinaryTreePaths{
      public static void main(String[] args) {
           Solution solution = new BinaryTreePaths().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, new StringBuilder(), paths);
        return paths;
    }

    // 先序遍历
    private void dfs(TreeNode node, StringBuilder path, List<String> paths) {
        if (node == null) {
            return;
        }
        path.append(node.val);
        if (isLeafNode(node)) {
            paths.add(path.toString());
        } else {
            // 有往下走的路
            path.append("->");
            // 分叉
            dfs(node.left, new StringBuilder(path), paths);
            dfs(node.right, new StringBuilder(path), paths);
        }
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }