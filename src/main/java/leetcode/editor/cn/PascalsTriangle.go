  package leetcode.editor.cn;
  
  /**
   * [118] 杨辉三角
   */
  public class PascalsTriangle{
      public static void main(String[] args) {
           Solution solution = new PascalsTriangle().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func generate(numRows int) [][]int {
  if numRows == 1 {
    return [][]int{{1}}
  }
  ans := [][]int{{1}}
  for i:=2;i<=numRows;i++ {
    newArr := getNew(ans[len(ans)-1])
    ans = append(ans, newArr)
  }
  return ans
}

func getNew(arr []int) []int {
  newArr := []int{1}
  for i:=0;i<len(arr)-1;i++ {
    newArr = append(newArr, arr[i]+arr[i+1])
  }
  newArr = append(newArr, 1)
  return newArr
}

//leetcode submit region end(Prohibit modification and deletion)

  }