  package leetcode.editor.cn;
  
  /**
   * [42] 接雨水
   */
  public class TrappingRainWater{
      public static void main(String[] args) {
           Solution solution = new TrappingRainWater().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func trap(height []int) int {
  stack := []int{}
  total := 0
  for i:=0;i<len(height);i++ {
    for len(stack) > 0 && height[i] > height[stack[len(stack)-1]] {
      // pop
      bottomIndex := stack[len(stack)-1]
      stack = stack[:len(stack)-1]
      if len(stack) == 0 {
        break
      }
      // peek
      leftIndex := stack[len(stack)-1]

      v := (i - leftIndex - 1) * (min(height[i], height[leftIndex]) - height[bottomIndex])
      total += v
    }
    stack = append(stack, i)
  }
  return total
}

func min(a int, b int) int {
  if a < b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }