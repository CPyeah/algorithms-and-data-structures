  package leetcode.editor.cn;
  
  /**
   * [48] 旋转图像
   */
  public class RotateImage{
      public static void main(String[] args) {
           Solution solution = new RotateImage().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func rotate(matrix [][]int)  {
  // 上下颠倒  matrix[i][j] = matrix[len-i-1][j]
  for i:=0;i<len(matrix)/2;i++ {
    for j:=0;j<len(matrix[0]);j++ {
      matrix[i][j],matrix[len(matrix)-i-1][j] = matrix[len(matrix)-i-1][j],matrix[i][j]
    }
  }
  // i,j 镜像颠倒  matrix[i][j] = matrix[j][i]
  for i:=0;i<len(matrix);i++ {
    for j:=i+1;j<len(matrix[0]);j++ {
      matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

  }