  package leetcode.editor.cn;
  
  /**
   * [191] 位1的个数
   */
  public class NumberOf1Bits{
      public static void main(String[] args) {
           Solution solution = new NumberOf1Bits().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func hammingWeight(num uint32) int {
    count := 0
    for i:=0;i<32;i++ {
      // 看最后一位是不是 1
      if num & 1 == 1 {
        count ++
      }
      // 右移 1 位
      num >>= 1
    }
    return count
}
//leetcode submit region end(Prohibit modification and deletion)

  }