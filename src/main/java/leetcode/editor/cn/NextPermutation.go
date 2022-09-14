  package leetcode.editor.cn;
  
  /**
   * [31] 下一个排列
   */
  public class NextPermutation{
      public static void main(String[] args) {
           Solution solution = new NextPermutation().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func nextPermutation(nums []int)  {
  if len(nums) < 2 {
    return
  }
  // find smaller than next place
  var targetIndex int
  for targetIndex=len(nums)-2;targetIndex>=0;targetIndex-- {
    if nums[targetIndex] < nums[targetIndex+1] {
      break
    }
  }
  if targetIndex == -1 {
    reverse(nums, 0, len(nums)-1)
  } else {
    // find just bigger than target item and swap
    for i := len(nums)-1; i > targetIndex; i-- {
      if nums[i] > nums[targetIndex] {
        nums[i], nums[targetIndex] = nums[targetIndex], nums[i]
        break
      }
    }
    // reverse targetIndex right items
    reverse(nums, targetIndex+1, len(nums)-1)
  }
}

func reverse(nums []int, l int, r int) {
  for l < r {
    nums[l], nums[r] = nums[r], nums[l]
    l++
    r--
  }
}
//leetcode submit region end(Prohibit modification and deletion)

  }