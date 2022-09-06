  package leetcode.editor.cn;
  
  /**
   * [560] 和为 K 的子数组
   */
      //leetcode submit region begin(Prohibit modification and deletion)
func subarraySum(nums []int, k int) int {
  ans := 0
  l := len(nums)
  sum := 0
  dict := make(map[int]int)
  dict[0] = 1
  for i:=0;i<l;i++ {
     sum += nums[i]
     diff := sum - k
     c := dict[diff]
     ans += c
     dict[sum] ++
  }
  return ans
}


//leetcode submit region end(Prohibit modification and deletion)

  }