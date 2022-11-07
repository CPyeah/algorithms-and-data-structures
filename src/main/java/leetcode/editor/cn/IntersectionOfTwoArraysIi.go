  package leetcode.editor.cn;
  
  /**
   * [350] 两个数组的交集 II
   * 
   * 1 (1:Easy; 2:Medium; 3:Hard)
   */
  public class IntersectionOfTwoArraysIi{
      public static void main(String[] args) {
           Solution solution = new IntersectionOfTwoArraysIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func intersect(nums1 []int, nums2 []int) []int {
  // nums1 into a set
  set := make(map[int]int)
  for _,n := range nums1 {
    set[n] ++
  }
  ans := make([]int, 0)
  for _,n := range nums2 {
    if set[n] > 0 {
      set[n] --
      ans = append(ans, n)
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }