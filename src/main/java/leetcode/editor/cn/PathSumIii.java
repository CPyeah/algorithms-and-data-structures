  package leetcode.editor.cn;

  import model.TreeNode;

  /**
   * [437] 路径总和 III
   */
  public class PathSumIii{
      public static void main(String[] args) {
           Solution solution = new PathSumIii().new Solution();
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
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return ;
        }
        pathSumWithRoot(root, targetSum, 0);
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

    }

    private void pathSumWithRoot(TreeNode root, int targetSum, long count) {
        if (root == null) {
            return;
        }
        count += root.val;
        if (count == targetSum) {
            ans ++;
        }
        pathSumWithRoot(root.left, targetSum, count);
        pathSumWithRoot(root.right, targetSum, count);

    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }