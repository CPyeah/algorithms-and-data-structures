  package leetcode.editor.cn;
  
  /**
   * [218] 天际线问题
   */
  public class TheSkylineProblem{
      public static void main(String[] args) {
           Solution solution = new TheSkylineProblem().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func getSkyline(buildings [][]int) [][]int {
  // build points
  points := getAllPoint(buildings)

  // sort points
  sort.Slice(points, func(i int, j int)bool {
    p1 := points[i]
    p2 := points[j]
    // 优先按照x排序
    if p1.x != p2.x {
      return p1.x < p2.x
    }
    // 如果x重合，左端点应该优先，即两个建筑重合
    if p1.pos != p2.pos {
      return p1.pos > p2.pos
    }
    // 如果x一样，且同是左端点，高的在前
    if p1.pos == 1 {
      return p1.y > p2.y
    } else {
      // 如果是右端点，矮的在前
      return p1.y < p2.y
    }
  })

  // scan points and output result
  // use heap
  heap := newHeap()
  result := make([][]int, 0)
  for _,p := range points {
    if p.pos == 1 {
      // 找到以前的最高，再把当前建筑push
      maxHigh := heap.getMax()
      heap.push(p)
      // 看当前的建筑是不是最高的
      if p.y > maxHigh {
        result = append(result, []int{p.x, p.y})
      }
    }
    if p.pos == -1 {
      // 先把当前建筑移除，看当前建筑的高，是不是最高的
      heap.remove(p.id)
      maxHigh := heap.getMax()
      // 如果是，输出
      if p.y > maxHigh {
        result = append(result, []int{p.x, maxHigh})
      }
    }
  }

  return result
}

func getAllPoint(buildings [][]int) []Point {
  points := make([]Point, 0)
  for i:=0;i<len(buildings);i++ {
    building := buildings[i]
    leftPoint := Point{i, building[0], building[2], 1}
    rightPoint := Point{i, building[1], building[2], -1}
    points = append(points, leftPoint)
    points = append(points, rightPoint)
  }
  return points
}

type Point struct {
  id int
  x int
  y int
  pos int // 1: 左边端点  -1:右边端点
}

type Heap struct {
  points map[int]Point
}

func newHeap() Heap {
  return Heap{make(map[int]Point)}
}

func (h Heap) getMax() int {
  m := 0
  for _,v:= range h.points {
    if v.y > m {
      m = v.y
    }
  }
  return m
}

func (h *Heap) push(p Point) {
  h.points[p.id] = p
}

func (h *Heap) remove(id int) {
  delete(h.points, id)
}
//leetcode submit region end(Prohibit modification and deletion)

  }