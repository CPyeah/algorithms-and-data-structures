  package leetcode.editor.cn;
  
  /**
   * [581] 最短无序连续子数组
   * [2,6,4,8,10,9,15]
   *   👆        👆
   */
      //leetcode submit region begin(Prohibit modification and deletion)
func findUnsortedSubarray(nums []int) int {
  // left -> right = minIdx
  minIdx := -1
  for i:=0;i<len(nums)-1;i++ {
    if nums[i] > nums[i+1] {
      minIdx = i
      break
    }
  }
  if minIdx == -1 {
    return 0
  }

  // right -> left = maxIdx
  maxIdx := -1
  for i:=len(nums)-1;i>0;i-- {
    if nums[i] < nums[i-1] {
      maxIdx = i
      break
    }
  }

  // get min and max
  min := nums[minIdx]
  max := nums[minIdx]
  for i:=minIdx+1;i<=maxIdx;i++ {
    if nums[i] < min {
      min = nums[i]
    }
    if nums[i] > max {
      max = nums[i]
    }
  }

  // find bigger and smaller index
  //  1,3,3, 2,2,2,4
  minIdx = -1
  for i:=0;i< len(nums);i++ {
    if nums[i] <= min {
      minIdx = i
    } else {
    break
    }
  }
  maxIdx = len(nums)
  for i:=len(nums)-1;i>=0;i--{
    if nums[i] >= max {
      maxIdx = i
    } else {
      break
    }
  }

  return maxIdx - minIdx -1
}

//leetcode submit region end(Prohibit modification and deletion)

  }