  package leetcode.editor.cn;
  
  /**
   * [287] 寻找重复数
   */
  public class FindTheDuplicateNumber{
      public static void main(String[] args) {
           Solution solution = new FindTheDuplicateNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func findDuplicate(nums []int) int {
  fast, slow := 0, 0
  for {
    fast = nums[nums[fast]]
    slow = nums[slow]
    if slow == fast {
        fast = 0
        for {
          fast = nums[fast]
          slow = nums[slow]
          if fast == slow {
            return slow
          }
        }
    }
  }
  return 0
}
//leetcode submit region end(Prohibit modification and deletion)

  }