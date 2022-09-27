  package leetcode.editor.cn;
  
  /**
   * [448] 找到所有数组中消失的数字
   */
  public class FindAllNumbersDisappearedInAnArray{
      public static void main(String[] args) {
           Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func findDisappearedNumbers(nums []int) []int {
  for i:=0;i<len(nums);i++ {
    nextIndex := abs(nums[i]) - 1
    nums[nextIndex] = negative(nums[nextIndex])
  }
  ans := make([]int, 0)
  for i,n := range nums {
    if n > 0 {
      ans = append(ans, i+1)
    }
  }
  return ans
}

func abs(n int) int {
  if n < 0 {
    return -n
  }
  return n
}

func negative(n int) int {
  return -abs(n)
}
//leetcode submit region end(Prohibit modification and deletion)

  }