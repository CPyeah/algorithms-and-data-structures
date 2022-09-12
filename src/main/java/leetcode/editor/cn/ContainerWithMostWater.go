  package leetcode.editor.cn;
  
  /**
   * [11] 盛最多水的容器
   */
  public class ContainerWithMostWater{
      public static void main(String[] args) {
           Solution solution = new ContainerWithMostWater().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maxArea(height []int) int {
  l := 0
  r := len(height)-1
  ans := 0
  for l < r {
    // calculate area
    area := (r - l) * min(height[l], height[r])
    ans = max(ans, area)
    // select and move pointer
    if height[l] < height[r] {
      l ++
    } else {
      r --
    }
  }
  return ans
}

func min(a int, b int) int {
  if a < b {
    return a
  }
  return b
}

func max(a int, b int) int {
  if a > b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }