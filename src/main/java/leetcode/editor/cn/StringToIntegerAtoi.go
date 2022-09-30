  package leetcode.editor.cn;
  
  /**
   * [8] 字符串转换整数 (atoi)
   */
  public class StringToIntegerAtoi{
      public static void main(String[] args) {
           Solution solution = new StringToIntegerAtoi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      // Status
      const other = "other"
      const sign = "sign"
      const integer = "integer"
      const float = "float"

      // Event
      const isOther = "isOther"
      const isSign = "isSign"
      const isNumber = "isNumber"
      const isPoint = "isPoint"
func myAtoi(s string) int {
	// "  xx  -4193 with words" -> -4193
	var ans = 0
	negative := false
	floatFlag := 1

	// Action
	var recordSign = func(b byte) {
		if b == '-' {
			negative = true
		}
	}
	var getInteger = func(b byte) {
		ans *= 10
		ans += b2i(b)
	}
	var getFloat = func(b byte) {
		floatFlag /= 10
		ans += b2i(b) * floatFlag
	}
	var finish = func() {
		if negative {
			ans = -ans
		}
	}

	status := other
	for i := 0; i < len(s); i++ {
		b := s[i]
		event := getEvent(b)
		if status == other {
			if event == isOther {
				continue
			} else if event == isSign {
				recordSign(b)
				status = sign
			} else if event == isNumber {
				getInteger(b)
				status = integer
			} else {
				return 0
			}
		} else if status == sign {
			if event == isNumber {
				getInteger(b)
				status = integer
			} else {
				return 0
			}
		} else if status == integer {
			if event == isNumber {
				getInteger(b)
				status = integer
			} else if event == isPoint {
				status = float
			} else if event == isOther {
				break
			} else {
				return 0
			}
		} else if status == float {
			if event == isNumber {
				getFloat(b)
			} else if event == isOther {
				break
			} else {
				return 0
			}
		} else {
			return 0
		}
	}
	finish()
	return ans
}

func getEvent(b byte) string {
	if b == '.' {
		return isPoint
	} else if b == '-' || b == '+' {
		return isSign
	} else if b2i(b) >= 0 && b2i(b) <= 9 {
		return isNumber
	} else {
		return isOther
	}
}

func b2i(b byte) int {
	return int(b) - int('0')
}

//leetcode submit region end(Prohibit modification and deletion)

  }