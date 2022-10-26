  package leetcode.editor.cn;
  
  /**
   * [227] 基本计算器 II
   */
  public class BasicCalculatorIi{
      public static void main(String[] args) {
           Solution solution = new BasicCalculatorIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
func calculate(s string) int {
  numStack := make([]int, 0)
  signStack := make([]byte, 0)

  stringTemp := ""
  for i:=0;i<len(s);i++ {
    if unicode.IsDigit(rune(s[i])) {
      stringTemp += string(s[i])
    } else if isSign(s[i]) {
      // add number into numStack
      n, _ := strconv.Atoi(stringTemp)
      stringTemp = ""
      numStack = append(numStack, n)

      // if current sign is not higher the top of signStack
      for needCalculate(signStack, s[i]) {
        calculateStack(&numStack, &signStack)
      }
      signStack = append(signStack, s[i])
    }
  }

  // add last number into numStack
  n, _ := strconv.Atoi(stringTemp)
  stringTemp = ""
  numStack = append(numStack, n)

  for len(signStack) > 0 {
    calculateStack(&numStack, &signStack)
  }

  return numStack[0]
}

func calculateStack(numStack *[]int, signStack *[]byte) {
	n1 := (*numStack)[len(*numStack)-2]
	n2 := (*numStack)[len(*numStack)-1]
	*numStack = (*numStack)[:len(*numStack)-2]

	sign := (*signStack)[len(*signStack)-1]
	*signStack = (*signStack)[:len(*signStack)-1]

	result := calculateNum(n1, n2, sign)
	*numStack = append(*numStack, result)
}

func calculateNum(n1 int, n2 int, sign byte) int {
  if sign == '+' {
    return n1 + n2
  }
  if sign == '-' {
    return n1 - n2
  }
  if sign == '*' {
    return n1 * n2
  }
  if sign == '/' {
    return n1 / n2
  }
  return 0
}

func isSign(b byte) bool {
  if b == '+' || b == '-' || b == '*' || b == '/' {
    return true
  }
  return false
}

func needCalculate(signStack []byte, sign byte)bool {
  if len(signStack) == 0 {
    return false
  }
  if sign == '+' || sign == '-' {
    return true
  }
  topSign := signStack[len(signStack)-1]
  if topSign == '*' || topSign == '/' {
    return true
  }
  return false
}
//leetcode submit region end(Prohibit modification and deletion)

  }