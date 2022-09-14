  package leetcode.editor.cn;
  
  /**
   * [34] 在排序数组中查找元素的第一个和最后一个位置
   */
  public class FindFirstAndLastPositionOfElementInSortedArray{
      public static void main(String[] args) {
           Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func searchRange(nums []int, target int) []int {
  if len(nums) == 0 {
    return []int{-1, -1}
  }
  left := findLeftSide(nums, 0, len(nums)-1, target)
  right := findRightSide(nums, 0, len(nums)-1, target)
  return []int{left, right}
}
func findLeftSide(nums []int, l int, r int, target int) int {
  if l == 0 && nums[l] == target {
    return l
  }
  if nums[l] == target && nums[l-1] != target{
    return l
  }
  if nums[r] == target && nums[r-1] != target {
    return r
  }
  if r - l < 2 {
    return -1
  }
  m := (r + l) / 2
  if nums[m] == target && nums[m-1] != target {
    return m
  }
  if nums[m] < target {
    return findLeftSide(nums, m, r, target)
  } else {
    return findLeftSide(nums, l, m, target)
  }
}

func findRightSide(nums []int, l int, r int, target int) int {
  if r == len(nums)-1 && nums[r] == target {
    return r
  }
  if nums[r] == target && nums[r+1] != target {
    return r
  }
  if nums[l] == target && nums[l+1] != target{
    return l
  }
  if r - l < 2 {
    return -1
  }
  m := (r + l) / 2
  if nums[m] == target && nums[m+1] != target {
    return m
  }
  if nums[m] > target {
    return findRightSide(nums, l, m, target)
  } else {
    return findRightSide(nums, m, r, target)
  }
}
//leetcode submit region end(Prohibit modification and deletion)

  }