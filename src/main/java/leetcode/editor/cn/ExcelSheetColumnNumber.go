  package leetcode.editor.cn;
  
  /**
   * [171] Excel 表列序号
   */
  public class ExcelSheetColumnNumber{
      public static void main(String[] args) {
           Solution solution = new ExcelSheetColumnNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func titleToNumber(columnTitle string) int {
  ans := 0
  for i:=0;i<len(columnTitle);i++ {
    b := columnTitle[i]
    n := getNumber(b) * getPos(len(columnTitle)-i-1)
    ans += n
  }
  return ans
}

func getPos(time int) int {
  if time == 0 {
    return 1
  }
  ret := 1
  for i:=1;i<=time;i++ {
    ret *= 26
  }
  return ret
}

func getNumber(b byte) int {
  return int(b) - int('A') + 1
}
//leetcode submit region end(Prohibit modification and deletion)

  }