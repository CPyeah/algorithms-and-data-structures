  package leetcode.editor.cn;
  
  /**
   * [1] Two Sum
   */
  public class TwoSum{
      public static void main(String[] args) {
           Solution solution = new TwoSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func twoSum(nums []int, target int) []int {
    numMap := make(map[int]int)
    var currentNum int
    var diffNum int
    for i:=0;i<len(nums);i++ {
      currentNum = nums[i]
      diffNum = target - currentNum
      if idx,ok := numMap[diffNum]; ok {
        return []int{idx, i}
      } else {
        numMap[currentNum] = i
      }
    }
    return []int{}
}
//leetcode submit region end(Prohibit modification and deletion)

  }