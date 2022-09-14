  package leetcode.editor.cn;
  
  /**
   * [33] 搜索旋转排序数组
   */
  public class SearchInRotatedSortedArray{
      public static void main(String[] args) {
           Solution solution = new SearchInRotatedSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func search(nums []int, target int) int {
  return binarySearch(nums, 0, len(nums)-1, target)
}

func binarySearch(nums []int, l int, r int, target int) int {
  if nums[l] == target {
    return l
  }
  if nums[r] == target {
    return r
  }
  if r - l < 2 {
    return -1
  }
  m := (l + r) / 2
  if nums[m] == target {
    return m
  }

  // left is order
  if nums[l] < nums[m] {
    if nums[l] < target && target < nums[m] {
      // search left
      return binarySearch(nums, l, m, target)
    } else {
      // search right
      return binarySearch(nums, m, r, target)
    }
  }
  // right is order
  if nums[m] < nums[r] {
    if nums[m] < target && target < nums[r] {
      // search right
      return binarySearch(nums, m, r, target)
    } else {
      // search left
      return binarySearch(nums, l, m, target)
    }
  }
  return -1
}
//leetcode submit region end(Prohibit modification and deletion)

  }