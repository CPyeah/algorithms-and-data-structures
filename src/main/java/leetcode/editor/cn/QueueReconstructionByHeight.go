  package leetcode.editor.cn;
  
  /**
   * [406] 根据身高重建队列
   */
  public class QueueReconstructionByHeight{
      public static void main(String[] args) {
           Solution solution = new QueueReconstructionByHeight().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func reconstructQueue(people [][]int) [][]int {
  sort.Slice(people, func(i, j int)bool {
    if people[i][0] != people[j][0] {
      return people[i][0] > people[j][0]
    }
      return people[i][1] < people[j][1]
  })
  for i:=0;i<len(people);i++ {
    p := people[i]
    pos := p[1]
    if pos < i {
      // move p to i
      for j:=i-1;j>=pos;j-- {
        people[j+1] = people[j]
      }
      people[pos] = p
    }
  }
  return people
}
//leetcode submit region end(Prohibit modification and deletion)

  }