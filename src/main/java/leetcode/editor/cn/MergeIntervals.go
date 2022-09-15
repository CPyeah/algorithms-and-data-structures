  package leetcode.editor.cn;
  
  /**
   * [56] 合并区间
   */
  public class MergeIntervals{
      public static void main(String[] args) {
           Solution solution = new MergeIntervals().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func merge(intervals [][]int) [][]int {
  sort.Slice(intervals, func(i int, j int)bool {
    return intervals[i][0] < intervals[j][0]
  })
  l := 0
  r := 0
  ans := make([][]int, 0)
  rightEndValue := -1
  for r < len(intervals) {
    // 右边界 要注意， 取最大值
    rightEndValue = max(rightEndValue, intervals[r][1])
    if rightNextCanMerge(intervals, r, rightEndValue) {
      r ++
    } else {
      // merge into ans
      res := []int{intervals[l][0], rightEndValue}
      ans = append(ans, res)
      r ++
      l = r
    }
  }
  return ans
}

func rightNextCanMerge(intervals [][]int, r int, rightEndValue int)bool {
  if r == len(intervals)-1 {
    return false
  }
  if rightEndValue >= intervals[r+1][0] {
    return true
  }
  return false
}

func max(a int, b int)int {
  if a > b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }