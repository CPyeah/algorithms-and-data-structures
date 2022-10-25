  package leetcode.editor.cn;
  
  /**
   * [210] 课程表 II
   */
  public class CourseScheduleIi{
      public static void main(String[] args) {
           Solution solution = new CourseScheduleIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func findOrder(numCourses int, prerequisites [][]int) []int {

  // buildGraph
  preCoursesMap, nextCoursesMap := buildGraph(prerequisites)

  studiedCourse := make([]int, 0)

  // BFS
  queue := make([]int, 0)
  for i:=0;i<numCourses;i++ {
    if preCoursesMap[i] == 0 {
      queue = append(queue, i)
    }
  }

  for len(queue) > 0 {
    // study a course
    c := queue[len(queue)-1]
    queue = queue[:len(queue)-1]
    studiedCourse = append(studiedCourse, c)

    nextCourses := nextCoursesMap[c]
    for _,nc := range nextCourses {
      preCoursesMap[nc]--
      if preCoursesMap[nc] == 0 {
        queue = append(queue, nc)
      }
    }

  }
  if len(studiedCourse) < numCourses {
    return []int{}
  }
  return studiedCourse
}

func buildGraph(prerequisites [][]int)(map[int]int, map[int][]int) {
  preCoursesMap := make(map[int]int)
  nextCoursesMap := make(map[int][]int)
  for i:=0;i<len(prerequisites);i++ {
    courseRel := prerequisites[i]
    preCourse := courseRel[1] // 先学的课程
    nextCourse := courseRel[0] // 后学的课程
    // preCourse -> nextCourse
    preCoursesMap[nextCourse] ++

    if nextCoursesMap[preCourse] == nil {
      nextCoursesMap[preCourse] = make([]int, 0)
    }
    nextCoursesMap[preCourse] = append(nextCoursesMap[preCourse], nextCourse)
  }
  return preCoursesMap, nextCoursesMap
}
//leetcode submit region end(Prohibit modification and deletion)

  }