  package leetcode.editor.cn;
  
  /**
   * [179] 最大数
   */
  public class LargestNumber{
      public static void main(String[] args) {
           Solution solution = new LargestNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func largestNumber(nums []int) string {
  // change to string
  stringNums := make([]string, len(nums))
  for i:=0;i<len(nums);i++ {
    stringNums[i] = strconv.Itoa(nums[i])
  }

  // sort this string array
  sort.Slice(stringNums, func(i int, j int)bool {
    l := stringNums[i]
    r := stringNums[j]
    n1, _ := strconv.Atoi(l+r)
    n2, _ := strconv.Atoi(r+l)
    return n1 > n2
  })

  // join to one string
  return removeZero(strings.Join(stringNums, ""))
}

func removeZero(s string) string {
  if s[0] == '0' {
    return "0"
  }
  return s
}

func getByte(s string, i int) byte {
  if i>=len(s) {
    return s[len(s)-1]
  }
  return s[i]
}

func max(a int, b int) int {
  if a > b {
    return a
  }
  return b
}
//leetcode submit region end(Prohibit modification and deletion)

  }