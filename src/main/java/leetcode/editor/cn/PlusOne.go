  package leetcode.editor.cn;
  
  /**
   * [66] 加一
   */
  public class PlusOne{
      public static void main(String[] args) {
           Solution solution = new PlusOne().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func plusOne(digits []int) []int {
  // 先给最后一位加 1
  digits[len(digits)-1] ++

  // 处理进位问题
  addOneFlag := false
  for i:=len(digits)-1;i>=0;i-- {
    if addOneFlag {
      digits[i] ++
      addOneFlag = false
    }
    if digits[i] > 9{
      digits[i] -= 10
      addOneFlag = true
    }
  }
  if addOneFlag {
    digits = append([]int{1}, digits...)
  }
  return digits
}
//leetcode submit region end(Prohibit modification and deletion)

  }