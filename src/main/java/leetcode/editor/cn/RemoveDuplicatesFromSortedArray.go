  package leetcode.editor.cn;
  
  /**
   * [26] 删除有序数组中的重复项
   */
  public class RemoveDuplicatesFromSortedArray{
      public static void main(String[] args) {
           Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func removeDuplicates(nums []int) int {
  if len(nums) < 2 {
    return len(nums)
  }
  numIndex := 1
  // nums[i] 和 nums[i-1]比较
  // 如果一样，i++
  // 如果不一样，swap，numIndex++, i++
  for i:=1;i<len(nums);i++ {
    if nums[i] != nums[i-1] {
      nums[numIndex] = nums[i]
      numIndex ++
    }
  }
  return numIndex
}
//leetcode submit region end(Prohibit modification and deletion)

  }