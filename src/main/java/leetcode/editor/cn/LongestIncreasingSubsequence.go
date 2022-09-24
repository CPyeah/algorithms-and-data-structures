  package leetcode.editor.cn;
  
  /**
   * [300] 最长递增子序列
   */
  public class LongestIncreasingSubsequence{
      public static void main(String[] args) {
           Solution solution = new LongestIncreasingSubsequence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func lengthOfLIS(nums []int) int {
  dp := make([]int, len(nums))
  dp[0] = 1
  ans := 1

  // 矮子从中挑高个子
  helper := func(currentIndex int) int {
    res := 1
    for i:=0;i<currentIndex;i++ {
      if nums[i] < nums[currentIndex] {
        if dp[i] + 1 > res {
          res = dp[i] + 1
        }
      }
    }
    return res
  }

  for i:=1;i<len(nums);i++ {
    dp[i] = helper(i)
    if dp[i] > ans {
      ans = dp[i]
    }
  }
  return ans
}

//leetcode submit region end(Prohibit modification and deletion)

  }