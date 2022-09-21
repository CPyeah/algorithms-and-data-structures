  package leetcode.editor.cn;
  
  /**
   * [136] 只出现一次的数字
   */
  public class SingleNumber{
      public static void main(String[] args) {
           Solution solution = new SingleNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func singleNumber(nums []int) int {
  if len(nums) == 0 {
    return 0
  }
  ans := nums[0]
  for i:=1;i<len(nums);i++ {
    ans ^= nums[i]
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }