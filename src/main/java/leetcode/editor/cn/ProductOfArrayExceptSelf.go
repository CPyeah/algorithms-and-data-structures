  package leetcode.editor.cn;
  
  /**
   * [238] 除自身以外数组的乘积
   */
  public class ProductOfArrayExceptSelf{
      public static void main(String[] args) {
           Solution solution = new ProductOfArrayExceptSelf().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func productExceptSelf(nums []int) []int {
  l := len(nums)
  ans := make([]int, l)
  // left -> right
  left := 1
  for i:=0;i<l;i++ {
    ans[i] = left
    left *= nums[i]
  }
  // right -> left
  right := 1
  for i:=l-1;i>-1;i-- {
    ans[i] *= right
    right *= nums[i]
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }