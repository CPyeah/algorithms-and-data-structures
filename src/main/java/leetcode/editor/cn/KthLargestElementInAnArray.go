  package leetcode.editor.cn;
  
  /**
   * [215] 数组中的第K个最大元素
   */
  public class KthLargestElementInAnArray{
      public static void main(String[] args) {
           Solution solution = new KthLargestElementInAnArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func findKthLargest(nums []int, k int) int {
  left, right, t := 0, len(nums)-1, k-1
  var quickSelect func() int
  quickSelect = func() int {
    pivot := nums[right]
    bigger := left
    for i:=left;i<right;i++ {
      if nums[i] > pivot {
        nums[bigger], nums[i] = nums[i], nums[bigger]
        bigger ++
      }
    }
    nums[bigger], nums[right] = nums[right], nums[bigger]
    return bigger
  }
  for {
    index := quickSelect()
    if index == t {
      return nums[index]
    }
    if index < t {
      left = index+1
    } else {
      right = index-1
    }
  }
  return -1
}
//leetcode submit region end(Prohibit modification and deletion)

  }