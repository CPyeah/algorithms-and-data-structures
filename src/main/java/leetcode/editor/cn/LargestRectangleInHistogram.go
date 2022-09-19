  package leetcode.editor.cn;
  
  /**
   * [84] 柱状图中最大的矩形
   */
  public class LargestRectangleInHistogram{
      public static void main(String[] args) {
           Solution solution = new LargestRectangleInHistogram().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func largestRectangleArea(heights []int) int {
  heights = append(heights, 0)
  heights = append([]int{0}, heights...)
  stack := make([]int, 0)
  maxArea := 0
  for i:=0;i<len(heights);i++ {
    for len(stack) > 0 && heights[i] < heights[stack[len(stack)-1]] {
      // pop
      topIndex := stack[len(stack)-1]
      stack = stack[:len(stack)-1]

      // area = pop() * (i - peek() - 1)
      leftSideIndex := stack[len(stack)-1]
      currentArea := (i - leftSideIndex - 1) * heights[topIndex]
      maxArea = max(maxArea, currentArea)
    }
    // push
    stack = append(stack, i)
  }

  return maxArea
}
func max(a int, b int) int {
  if a > b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }