  package leetcode.editor.cn;
  
  /**
   * [75] 颜色分类
   */
  public class SortColors{
      public static void main(String[] args) {
           Solution solution = new SortColors().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func sortColors(nums []int)  {
  p0 := 0
  p2 := len(nums)-1
  i := 0
  for i <= p2 {
    if nums[i] == 0 {
      swap(nums, p0, i)
      i ++
      p0 ++
    } else if nums[i] == 2 {
      swap(nums, p2, i)
      p2 --
    } else {
      i ++
    }
  }
}
func swap(nums []int, i int, j int) {
  if i == j {
    return
  }
  nums[i], nums[j] = nums[j], nums[i]
}
//leetcode submit region end(Prohibit modification and deletion)

  }