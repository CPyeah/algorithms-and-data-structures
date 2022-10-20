  package leetcode.editor.cn;
  
  /**
   * [149] 直线上最多的点数
   */
  public class MaxPointsOnALine{
      public static void main(String[] args) {
           Solution solution = new MaxPointsOnALine().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maxPoints(points [][]int) int {
  if len(points) < 3 {
    return len(points)
  }
  maxCount := 0
  for i:=0;i<len(points);i++ {
    currentPoint := points[i]
    slopeMap := make(map[float64]int)
    for j:=i+1;j<len(points);j++ {
      secondPoint := points[j]
      slope := getSlope(currentPoint, secondPoint)
      slopeMap[slope]++
      if slopeMap[slope] > maxCount {
        maxCount = slopeMap[slope]
      }
    }
  }
  return maxCount + 1
}

func getSlope(p1 []int, p2 []int) float64 {
  x1 := float64(p1[0])
  y1 := float64(p1[1])
  x2 := float64(p2[0])
  y2 := float64(p2[1])
  if x1 == x2 {
    return math.MaxFloat64
  }
  return (y1-y2)/(x1-x2)
}

//leetcode submit region end(Prohibit modification and deletion)

  }