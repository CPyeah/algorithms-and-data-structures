  package leetcode.editor.cn;
  
  /**
   * [169] 多数元素
   */
  public class MajorityElement{
      public static void main(String[] args) {
           Solution solution = new MajorityElement().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func majorityElement(nums []int) int {
  current := nums[0]
  count := 1
  for i:=1;i<len(nums);i++ {
    if count == 0 {
      current = nums[i]
      count = 1
    } else {
      if current == nums[i] {
        count ++
      } else {
        count --
      }
    }
  }
  return current
}
//leetcode submit region end(Prohibit modification and deletion)

  }