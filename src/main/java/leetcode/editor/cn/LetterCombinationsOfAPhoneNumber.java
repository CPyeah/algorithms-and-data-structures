package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [17] 电话号码的字母组合
 */
public class LetterCombinationsOfAPhoneNumber {

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {

		private List<String> results = new ArrayList<>();

		private final Map<String, String> numbers = new HashMap<>();

		{
			numbers.put("2", "abc");
			numbers.put("3", "def");
			numbers.put("4", "ghi");
			numbers.put("5", "jkl");
			numbers.put("6", "mno");
			numbers.put("7", "pqrs");
			numbers.put("8", "tuv");
			numbers.put("9", "wxyz");
			numbers.put("0", "_");
		}

		//输入：digits = "23"
		//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
		public List<String> letterCombinations(String digits) {
			if (digits == null || digits.length() == 0) {
				return results;
			}
			letterCombinations(digits, digits.length());
			return results;
		}


		// 2  3
		//      a             b                 c
		//   d e f          d e f             d e f
		public void letterCombinations(String digits, int index) {
			String current = numbers.get(String.valueOf(digits.charAt(index - 1)));
			if (index == 1) {
				for (char c : current.toCharArray()) {
					results.add(String.valueOf(c));
				}
				return;
			}
			letterCombinations(digits, index - 1);
			add2Results(current);
		}

		private void add2Results(String current) {
			List<String> newResults = new ArrayList<>(results.size() * current.length());
			for (String item : results) {
				for (char c : current.toCharArray()) {
					newResults.add(item + c);
				}
			}
			results = newResults;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}