  package leetcode.editor.cn;
  
  /**
   * [128] 最长连续序列
   */
  public class LongestConsecutiveSequence{
      public static void main(String[] args) {
           Solution solution = new LongestConsecutiveSequence().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func longestConsecutive(nums []int) int {
  dict := make(map[int]bool)
  for _, n := range nums {
    dict[n] = true
  }
  ans := 0
  for k,_ := range dict {
    if dict[k-1] {
      continue
    }
    count := 1
    for dict[k+count] {
      count ++
    }
    if count > ans {
      ans = count
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }