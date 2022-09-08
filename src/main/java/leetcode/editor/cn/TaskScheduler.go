  package leetcode.editor.cn;
  
  /**
   * [621] 任务调度器
   */
  public class TaskScheduler{
      public static void main(String[] args) {
           Solution solution = new TaskScheduler().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func leastInterval(tasks []byte, n int) int {
  digits := make([]int, 26)
  for _,v := range tasks {
    digits[v-'A'] ++
  }
  sort.Slice(digits, func(i int, j int)bool{
    return digits[i] > digits[j]
  })
  maxCount := digits[0]
  maxItems := 0
  for _,v := range digits {
    if v == maxCount {
      maxItems ++
    } else {
      break
    }
  }
  ans := (maxCount - 1) * (n + 1) + maxItems
  if len(tasks) > ans {
    ans = len(tasks)
  }
  return ans
}
//leetcode submit region end(Prohibit modification and deletion)

  }