  package leetcode.editor.cn;
  
  /**
   * [15] 三数之和
   */
  public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func threeSum(nums []int) [][]int {
    result = make([][]int, 0)
    if len(nums) < 3 {
        return result
    }
    // 需要先排序
    sort.Ints(nums)
    for i:=0;i<len(nums)-2&&nums[i]<=0; {
        target := nums[i] * -1
        // 转换成 两数和
        twoSum(nums, i+1, len(nums)-1, target)
        i ++
        // 重复的就不再计算了
        for nums[i] == nums[i-1] && i<len(nums)-2 {
            i++
        }
    }

    return result
}

var result [][]int

func twoSum(nums []int, j int, k int, target int) {
    for j < k {
        // 注意重复
        if k != len(nums)-1 && nums[k] == nums[k+1] {
            k--
            continue
        }
        if nums[j] + nums[k] == target {
            r := []int{target*-1, nums[j], nums[k]}
            result = append(result, r)
            j ++
            k --
        } else if nums[j] + nums[k] < target {
            j ++
        } else {
            k --
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)

  }