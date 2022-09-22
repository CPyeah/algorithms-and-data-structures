  package leetcode.editor.cn;
  
  /**
   * [198] 打家劫舍
   */
  public class HouseRobber{
      public static void main(String[] args) {
           Solution solution = new HouseRobber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func rob(nums []int) int {
  if len(nums) == 1 {
    return nums[0]
  }
  if len(nums) == 2 {
    return max(nums[0], nums[1])
  }
  dp := make([]int, len(nums))
  dp[0] = nums[0]
  dp[1] = max(nums[0], nums[1])
  for i:=2;i<len(nums);i++ {
    dp[i] = max(dp[i-1], dp[i-2] + nums[i])
  }
  return dp[len(dp)-1]
}

func max(a int, b int) int{
  if a > b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }