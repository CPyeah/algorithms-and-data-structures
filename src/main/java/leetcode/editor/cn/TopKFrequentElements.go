  package leetcode.editor.cn;
  
  /**
   * [347] 前 K 个高频元素
   */
  public class TopKFrequentElements{
      public static void main(String[] args) {
           Solution solution = new TopKFrequentElements().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func topKFrequent(nums []int, k int) []int {
  counterMap := make(map[int]int)
  for _,n := range nums {
    counterMap[n] ++
  }

  counterArray := make([][]int, len(nums)+1)
  for n,c := range counterMap {
    if counterArray[c] == nil {
      counterArray[c] = make([]int, 0)
    }
    counterArray[c] = append(counterArray[c], n)
  }

  ans := make([]int, 0)
  for i:=len(counterArray)-1;i>=0;i-- {
    if len(counterArray[i]) > 0 {
      ans = append(ans, counterArray[i]...)
      if len(ans) == k {
        return ans
      }
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }