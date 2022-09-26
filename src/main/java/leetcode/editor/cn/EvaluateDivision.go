  package leetcode.editor.cn;
  
  /**
   * [399] 除法求值
   */
  public class EvaluateDivision{
      public static void main(String[] args) {
           Solution solution = new EvaluateDivision().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
var graph map[string][]Result
func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
  graph = make(map[string][]Result)
  for i:=0;i<len(equations);i++ {
    c := equations[i][0]
    d := equations[i][1]
    v := values[i]
    if graph[c] == nil {
      graph[c] = make([]Result, 0)
    }
    if graph[d] == nil {
      graph[d] = make([]Result, 0)
    }
    graph[c] = append(graph[c], Result{d, v})
    graph[d] = append(graph[d], Result{c, 1/v})
  }

  ans := make([]float64, len(queries))
  for i:=0;i<len(queries);i++ {
//     ans[i] = findDFS(queries[i][0], queries[i][1])
    ans[i] = findBFS(queries[i][0], queries[i][1])
  }
  return ans
}

func findBFS(left string, right string) float64 {
  if graph[left] == nil {
    return -1
  }
  visited := make(map[string]bool)

  queue := make([]Result, 0)
  queue = append(queue, Result{left, 1})
  for len(queue) != 0 {
    // pop
    node := queue[0]
    queue = queue[1:]
    visited[node.D] = true

    if right == node.D {
      return node.V
    }
    nextNodes := graph[node.D]
    for _,n := range nextNodes {
      if visited[n.D] {
        continue
      }
      // push
      queue = append(queue, Result{n.D, n.V * node.V})
    }
  }
  return -1
}

func findDFS(left string, right string) float64 {
  visited := make(map[string]bool)

  var bfs func(node string, value float64) float64
  bfs = func(node string, value float64) float64 {
    if graph[node] == nil {
      return -1
    }
    if node == right{
      return value
    }
    visited[node] = true
    nextNodes := graph[node]
    for _,n := range nextNodes {
      if visited[n.D] {
        continue
      }
      v := bfs(n.D, value*n.V)
      if v != -1 {
        return v
      }
    }
    return -1
  }
  return bfs(left, 1)
}

type Result struct{
  D string
  V float64
}

//leetcode submit region end(Prohibit modification and deletion)

  }