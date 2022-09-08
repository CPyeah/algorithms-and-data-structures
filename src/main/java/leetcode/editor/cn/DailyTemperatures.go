  package leetcode.editor.cn;
  
  /**
   * [739] 每日温度
   [73,74,75,71,69,72,76,73]
   */
  public class DailyTemperatures{
      public static void main(String[] args) {
           Solution solution = new DailyTemperatures().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func dailyTemperatures(temperatures []int) []int {
  ans := make([]int, len(temperatures))
  stack := make([]int, 0)
  for i:=0;i<len(temperatures);i++ {

    for len(stack) > 0 && temperatures[i] > temperatures[stack[len(stack)-1]]{
      // pop
      topIndex := stack[len(stack)-1]
      stack = stack[:len(stack)-1]
      ans[topIndex] = i - topIndex
    }
    stack = append(stack, i)

  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }