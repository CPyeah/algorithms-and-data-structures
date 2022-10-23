  package leetcode.editor.cn;
  
  /**
   * [217] 存在重复元素
   */
  public class ContainsDuplicate{
      public static void main(String[] args) {
           Solution solution = new ContainsDuplicate().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func containsDuplicate(nums []int) bool {
  cache := make(map[int]bool)
  for _,n := range nums {
    if cache[n] {
      return true
    } else {
      cache[n] = true
    }
  }
  return false
}
//leetcode submit region end(Prohibit modification and deletion)

  }