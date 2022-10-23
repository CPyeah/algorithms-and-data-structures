  package leetcode.editor.cn;
  
  /**
   * [204] 计数质数
   */
  public class CountPrimes{
      public static void main(String[] args) {
           Solution solution = new CountPrimes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func countPrimes(n int) int {
  if n < 3 {
    return 0
  }
  // 标记 arr[i] 不是素数
  arr := make([]bool, n)
  limit := int(math.Sqrt(float64(n)))
  for i:=2;i<=limit;i++ {
    if !arr[i] {
      // 标记所有的非质数
      signAllNoPrime(arr, i)
    }
  }

  // count
  res := 0
  for i:=2;i<len(arr);i++ {
    if !arr[i] {
      res++
    }
  }
  return res
}

func signAllNoPrime(arr []bool, k int) {
  // 当前数的所有的倍数，都不是质数
  for i:=2;;i++ {
    index := k * i
    if index < len(arr) {
      arr[index] = true
    } else {
      return
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

  }