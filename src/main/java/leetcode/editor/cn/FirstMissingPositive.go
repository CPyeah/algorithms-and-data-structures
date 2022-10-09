  package leetcode.editor.cn;
  
  /**
   * [41] 缺失的第一个正数
   */
  public class FirstMissingPositive{
      public static void main(String[] args) {
           Solution solution = new FirstMissingPositive().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func firstMissingPositive(nums []int) int {
  // find a positive number
  posNum := 0
  for i:=0;i<len(nums);i++ {
    if nums[i] > 0 {
      posNum = nums[i]
      break
    }
  }
  if posNum == 0 {
    return 1
  }

  // negative or 0 to posNum
  for i:=0;i<len(nums);i++ {
    if nums[i] <= 0 {
      nums[i] = posNum
    }
  }

  // change next number to negative
  for i:=0;i<len(nums);i++ {
    nextPos := abs(nums[i])-1
    if nextPos >= 0 && nextPos < len(nums) {
      nums[nextPos] = beNegative(nums[nextPos])
    }
  }

  // find first not negative position
  var ans = 1
  for {
    if ans == len(nums)+1 {
      return ans
    }
    if nums[ans-1] >= 0 {
      return ans
    }
    ans ++
  }
  return ans
}

func abs(n int) int {
  if n < 0 {
    return -n
  }
  return n
}

func beNegative(n int) int {
  return -abs(n)
}
//leetcode submit region end(Prohibit modification and deletion)

  }