  package leetcode.editor.cn;
  
  /**
   * [190] 颠倒二进制位
   */
  public class ReverseBits{
      public static void main(String[] args) {
           Solution solution = new ReverseBits().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func reverseBits(num uint32) uint32 {
    var res uint32 = 0
    var bit uint32
    for i:=0;i<32;i++ {
      // 找到最后一位的bit位
      bit = num & 1
      // 结果左移 1 位
      res <<= 1
      // res 加上 bit 到最后一位
      res |= bit
      // num 右移一位，把最后一位干掉
      num >>= 1
    }
    return res
}
//leetcode submit region end(Prohibit modification and deletion)

  }