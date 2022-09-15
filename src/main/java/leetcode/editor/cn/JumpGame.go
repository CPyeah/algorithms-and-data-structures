  package leetcode.editor.cn;
  
  /**
   * [55] 跳跃游戏
   */
  public class JumpGame{
      public static void main(String[] args) {
           Solution solution = new JumpGame().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func canJump(nums []int) bool {
  if len(nums) < 2 {
    return true
  }
  maxDistant := nums[0]
  for i:=1;i<=maxDistant;i++ {
    if maxDistant >= len(nums)-1 {
      return true
    }
    maxDistant = max(maxDistant, i+nums[i])
  }
  return false
}

func max(a int, b int)int {
  if a>b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }