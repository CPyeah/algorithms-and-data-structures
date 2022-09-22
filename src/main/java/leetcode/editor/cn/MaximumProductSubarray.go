  package leetcode.editor.cn;
  
  /**
   * [152] 乘积最大子数组
   */
  public class MaximumProductSubarray{
      public static void main(String[] args) {
           Solution solution = new MaximumProductSubarray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maxProduct(nums []int) int {
  ans := nums[0]
  maxVal := nums[0]
  minVal := nums[0]
  for i:=1;i<len(nums);i++ {
    mulMax := nums[i]*maxVal
    mulMin := nums[i]*minVal
    maxVal = max(nums[i], mulMax, mulMin)
    minVal = min(nums[i], mulMax, mulMin)
    if maxVal > ans {
      ans = maxVal
    }
  }
  return ans
}

func max(a int, b int, c int) int {
  m := a
  if b > m {
    m = b
  }
  if c > m {
    m = c
  }
  return m
}

func min(a int, b int, c int) int {
  m := a
  if b < m {
    m = b
  }
  if c < m {
    m = c
  }
  return m
}
//leetcode submit region end(Prohibit modification and deletion)

  }