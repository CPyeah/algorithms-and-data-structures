  package leetcode.editor.cn;
  
  /**
   * [338] 比特位计数
   */
  public class CountingBits{
      public static void main(String[] args) {
           Solution solution = new CountingBits().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func countBits(n int) []int {
  ans := make([]int, n+1)
  ans[0] = 0
  for i:=1;i<=n;i++ {
    ans[i] = ans[i/2] + i%2
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }