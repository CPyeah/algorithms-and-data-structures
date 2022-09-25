  package leetcode.editor.cn;
  
  /**
   * [239] 滑动窗口最大值
   */
  public class SlidingWindowMaximum{
      public static void main(String[] args) {
           Solution solution = new SlidingWindowMaximum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func maxSlidingWindow(nums []int, k int) []int {
  ans := make([]int, 0)
  deque := make([]int, 0)
  for i:=0;i<len(nums);i ++ {
    // remove i-k
    if i-k >= 0 && deque[0] == i-k {
      deque = deque[1:]
    }
    // add i into deque
    for len(deque) > 0 && nums[deque[len(deque)-1]] < nums[i] {
      deque = deque[:len(deque)-1]
    }
    deque = append(deque, i)

    // record ans
    if i >= k-1 {
      ans = append(ans, nums[deque[0]])
    }
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }