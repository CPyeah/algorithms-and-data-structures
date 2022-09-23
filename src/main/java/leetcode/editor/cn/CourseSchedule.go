  package leetcode.editor.cn;
  
  /**
   * [207] 课程表
   */
  public class CourseSchedule{
      public static void main(String[] args) {
           Solution solution = new CourseSchedule().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func canFinish(numCourses int, prerequisites [][]int) bool {
  // build map
  preMap := make(map[int]int)
  nextMap := make(map[int][]int)
  for _,v := range prerequisites {
    class := v[0] // 1
    need := v[1] // 0
    preMap[class]++
		if nextMap[need] == nil {
			nextMap[need] = make([]int, 0)
		}
		nextMap[need] = append(nextMap[need], class)
  }

  studiedCount := 0
  // BFS
  queue := make([]int, 0)
  for i:=0;i<numCourses;i++ {
    if preMap[i] == 0 {
      queue = append(queue, i)
      studiedCount ++
    }
  }
  for len(queue) != 0 {
    c := queue[0]
    queue = queue[1:]
    nextCourses := nextMap[c] // [1, 3]
    for _, v := range nextCourses {
      preMap[v] --
      if preMap[v] == 0 {
        queue = append(queue, v)
        studiedCount ++
      }
    }
  }

  return studiedCount == numCourses
}
//leetcode submit region end(Prohibit modification and deletion)

  }