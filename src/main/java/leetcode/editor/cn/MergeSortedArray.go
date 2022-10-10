  package leetcode.editor.cn;
  
  /**
   * [88] 合并两个有序数组
   */
  public class MergeSortedArray{
      public static void main(String[] args) {
           Solution solution = new MergeSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func merge(nums1 []int, m int, nums2 []int, n int)  {
  nums1 = nums1[:m]
  nums1 = append(nums1, nums2...)
  sort.Slice(nums1, func(i int, j int)bool {return nums1[i] < nums1[j]})
}
//leetcode submit region end(Prohibit modification and deletion)

  }