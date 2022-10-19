  package leetcode.editor.cn;
  
  /**
   * [162] 寻找峰值
   */
  public class FindPeakElement{
      public static void main(String[] args) {
           Solution solution = new FindPeakElement().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func findPeakElement(nums []int) int {
  if len(nums) == 1 {
    return 0
  }
  left := 0
  right := len(nums)-1
  for left < right {
    if nums[left] > nums[left+1] {
      return left
    }
    if nums[right] > nums[right-1] {
      return right
    }
    mid := (left + right) / 2
    if nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1] {
      return mid
    }
    if nums[mid-1] > nums[mid] {
      right = mid -1
    } else {
      left = mid + 1
    }
  }
  return -1
}

/**
[1,2,1,3,5,6,4]
       👆
      [5,6,4]
         👆
**/
//leetcode submit region end(Prohibit modification and deletion)

  }