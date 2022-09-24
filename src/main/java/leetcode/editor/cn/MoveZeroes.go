  package leetcode.editor.cn;
  
  /**
   * [283] 移动零
   */
  public class MoveZeroes{
      public static void main(String[] args) {
           Solution solution = new MoveZeroes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func moveZeroes(nums []int)  {
  noZeroIndex := 0
  for i:=0;i<len(nums);i++ {
    if nums[i] != 0 {
      nums[i], nums[noZeroIndex] = nums[noZeroIndex], nums[i]
      noZeroIndex ++
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

  }