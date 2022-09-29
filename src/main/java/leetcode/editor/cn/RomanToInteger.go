  package leetcode.editor.cn;
  
  /**
   * [13] 罗马数字转整数
   */
  public class RomanToInteger{
      public static void main(String[] args) {
           Solution solution = new RomanToInteger().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func romanToInt(s string) int {
  dict := make(map[byte]int)
  dict['I'] = 1
  dict['V'] = 5
  dict['X'] = 10
  dict['L'] = 50
  dict['C'] = 100
  dict['D'] = 500
  dict['M'] = 1000
  ans := dict[s[0]]
  for i:= 1;i<len(s);i++ {
    ans += dict[s[i]]
    if dict[s[i]] > dict[s[i-1]] {
      ans -= 2*dict[s[i-1]]
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }