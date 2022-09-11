  package leetcode.editor.cn;
  
  /**
   * [4] 寻找两个正序数组的中位数
   */
  public class MedianOfTwoSortedArrays{
      public static void main(String[] args) {
           Solution solution = new MedianOfTwoSortedArrays().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	len1 := len(nums1)
	len2 := len(nums2)
	// make sure len1 <= len2
	if len2 < len1 {
		return findMedianSortedArrays(nums2, nums1)
	}
	point1Start := 0
	point1End := len1
	len := len1 + len2

	var (
		mid1   int
		mid2   int
		left1  int
		left2  int
		right1 int
		right2 int
	)
	for point1Start <= point1End {
		mid1, mid2 = getMid(point1Start, point1End, (len+1)/2)
		left1 = getLeft(nums1, mid1)
		right1 = getRight(nums1, mid1)
		left2 = getLeft(nums2, mid2)
		right2 = getRight(nums2, mid2)

		if right1 < left2 {
			point1Start = mid1+1
		} else if left1 > right2 {
			point1End = mid1-1
		} else {
			return getResult(left1, left2, right1, right2, len)
		}
	}
	return -1
}

func getMid(point1Start int, point1End int, totalLeftCount int) (int, int) {
	mid1 := (point1End + point1Start) / 2
	mid2 := totalLeftCount - mid1
	return mid1, mid2
}

func getLeft(nums []int, mid int) int {
	if mid == 0 {
		return math.MinInt
	} else {
		return nums[mid-1]
	}
}

func getRight(nums []int, mid int) int {
	if mid == len(nums) {
		return math.MaxInt
	} else {
		return nums[mid]
	}
}

func getResult(left1 int, left2 int, right1 int, right2 int, len int) float64 {
	if len%2 == 1 {
		return math.Max(float64(left1), float64(left2))
	} else {
		left := math.Max(float64(left1), float64(left2))
		right := math.Min(float64(right1), float64(right2))
		return (left + right) / 2
	}
}
//leetcode submit region end(Prohibit modification and deletion)

  }