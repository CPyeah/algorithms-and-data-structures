  package leetcode.editor.cn;
  
  /**
   * [189] 轮转数组
   */
  public class RotateArray{
      public static void main(String[] args) {
           Solution solution = new RotateArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func rotate(nums []int, k int)  {
  if len(nums) < 2 {
    return
  }
  k = k % len(nums)
//   rotate1(nums, k)
//   rotate2(nums, k)
  rotate3(nums, k)
}

// 暴力解，一步一步移动  时间复杂度：O(n^2)
func rotate1(nums []int, k int) {
  for i:=0;i<k;i++ {
    lastValue := nums[len(nums)-1]
    for i:=len(nums)-2;i>=0;i-- {
      nums[i+1] = nums[i]
    }
    nums[0] = lastValue
  }
}

// 分割成两个数组，再组合
func rotate2(nums []int, k int) {
  cutPos := len(nums)-k
  leftPart := nums[:cutPos]
  rightPart := nums[cutPos:]
  copy(nums, append(rightPart, leftPart...))
}

// 翻转，先翻转全部，再翻转左边部分，再翻转右边部分
func rotate3(nums []int, k int) {
  // reverse all array -> [7,6,5,4,3,2,1]
  reverse(nums, 0, len(nums)-1)

  // reverse left part -> [5,6,7,4,3,2,1]
  reverse(nums, 0, k-1)

  // reverse right part -> [5,6,7,1,2,3,4]
  reverse(nums, k, len(nums)-1)
}

func reverse(nums []int, left int, right int) {
  for left < right {
    nums[left], nums[right] = nums[right], nums[left]
    left++
    right--
  }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
[1,2,3,4,5,6,7]
[7,6,5,4,3,2,1]
reverse left part
[5,6,7,4,3,2,1]
reverse right part
[5,6,7,1,2,3,4]
**/
  }