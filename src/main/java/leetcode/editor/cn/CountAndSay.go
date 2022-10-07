  package leetcode.editor.cn;
  
  /**
   * [38] 外观数列
   */
  public class CountAndSay{
      public static void main(String[] args) {
           Solution solution = new CountAndSay().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func countAndSay(n int) string {
  num := "1"
  for i:=2;i<=n;i++ {
    num = say(num)
  }
  return num
}
func say(seq string) string {
  count := 0
  target := seq[0]
  res := ""
  for i:=0;i<len(seq);i++ {
    if seq[i] == target {
      count++
    } else {
      res += strconv.Itoa(count)
      res += string(target)
      target = seq[i]
      count = 1
    }
  }
  // last one target
  res += strconv.Itoa(count)
  res += string(target)
  return res
}
//leetcode submit region end(Prohibit modification and deletion)

  }