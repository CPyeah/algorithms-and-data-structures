package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static class Solution1 {

		public List<List<String>> result = new ArrayList<>();

		public List<List<String>> solveNQueens(int n) {
			List<Integer[]> resultList = new ArrayList<>();
			if (n <= 0) {
				return result;
			}
			search(n, resultList);

			return result;

		}

		private void search(int n, List<Integer[]> resultList) {
			Integer[] rows = new Integer[n];
			searchNextRow(rows, 0, resultList);
		}

		/**
		 * 给row行  加棋子
		 *
		 * @param queens     棋盘（满足皇后条件）
		 * @param row        行
		 * @param resultList 结果集
		 */
		private void searchNextRow(Integer[] queens, int row, List<Integer[]> resultList) {
			if (row >= queens.length) {
				printQueens(queens);
				resultList.add(queens);
				return;
			}
			for (int col = 0; col < queens.length; col++) {
				// 在第row行上， 给第col列放棋子 试试
				if (isValid(queens, row, col)) {
					Integer[] newQueens = Arrays.copyOf(queens, queens.length);
					newQueens[row] = col;
					searchNextRow(newQueens, row + 1, resultList);
				}
			}
		}

		private void printQueens(Integer[] queens) {
			System.out.println(Arrays.toString(queens));
			ArrayList<String> list = new ArrayList<>(queens.length);
			for (Integer queen : queens) {
				StringBuilder sb = new StringBuilder();
				int col = queen;
				for (int j = 0; j < col; j++) {
					sb.append(".");
				}
				sb.append("Q");
				for (int j = 0; j < queens.length - 1 - queen; j++) {
					sb.append(".");
				}
				System.out.println(sb.toString());
				list.add(sb.toString());
			}
			result.add(list);
		}

		private boolean isValid(Integer[] queens, int row, int col) {
			if (row == 0) {
				return true;
			}
			for (int i = 0; i < row; i++) {
				if (queens[i] == col) {
					return false;
				}
				if (Math.abs(row - i) == Math.abs(col - queens[i])) {
					return false;
				}
			}
			return true;
		}
	}

}
