  package leetcode.editor.cn;
  
  /**
   * [53] 最大子数组和
   */
  public class MaximumSubarray{
      public static void main(String[] args) {
           Solution solution = new MaximumSubarray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maxSubArray(nums []int) int {
  dp := make([]int, len(nums))
  dp[0] = nums[0]
  ans := dp[0]
  for i:=1;i<len(nums);i++ {
    dp[i] = max(nums[i], dp[i-1] + nums[i])
    ans = max(ans, dp[i])
  }
  return ans
}

func max(a int, b int)int {
  if a > b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }