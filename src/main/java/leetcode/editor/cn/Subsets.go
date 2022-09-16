  package leetcode.editor.cn;
  
  /**
   * [78] 子集
   */
  public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func subsets(nums []int) [][]int {
  ans := make([][]int, 0)
  ans = append(ans, []int{})
  for _, n := range nums {
    currentLen := len(ans)
    for i:=0;i<currentLen;i++ {
      inAns := ans[i]
      newAns := make([]int, len(inAns))
      copy(newAns, inAns)
      newAns = append(newAns, n)
      // 诡，居然需要排序才能通过
      sort.Slice(newAns, func(i int, j int)bool{return newAns[i]<newAns[j]})
      ans = append(ans, newAns)
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }