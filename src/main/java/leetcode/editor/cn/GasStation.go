  package leetcode.editor.cn;
  
  /**
   * [134] 加油站
   */
  public class GasStation{
      public static void main(String[] args) {
           Solution solution = new GasStation().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func canCompleteCircuit(gas []int, cost []int) int {
  length := len(gas)
  sumDiff := 0
  currentGas := 0
  noGasPosPlusOne := 0
  for i:=0;i<length;i++ {
    diff := gas[i] - cost[i]
    sumDiff += diff
    currentGas += diff
    if currentGas < 0 {
      noGasPosPlusOne = i + 1
      currentGas = 0
    }
  }
  if sumDiff < 0 {
    return -1
  }

  return noGasPosPlusOne
}
/**
  0__1___2____34_0
  1  2   3    45

  [5, 1,2, 3,4]
  [4, 4,1, 5,1]
  [1,-3,1,-2,3]


  [1,2,3,4,5]
  [3,4,5,1,2]
  [-2,-2,-2,3,3]
**/
//leetcode submit region end(Prohibit modification and deletion)

  }