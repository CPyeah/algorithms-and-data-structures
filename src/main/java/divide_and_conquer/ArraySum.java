package divide_and_conquer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

// 数据求和
public class ArraySum {

	// 循环
	public static class Solution1 {

		public int arraySum(int[] array) {
			int result = 0;
			for (int j : array) {
				result += j;
			}
			return result;
		}
	}

	// 递归
	public static class Solution2 {

		public int arraySum(int[] array) {
			return sum(array, 0, array.length - 1);
		}

		public int sum(int[] array, int left, int right) {
			if (left == right) {
				return array[left];
			}
			if (right - left == 1) {
				return array[right] + array[left];
			}
			int mid = (left + right) / 2;
			return sum(array, left, mid) + sum(array, mid + 1, right);
		}
	}

	// fork-join-pool
	public static class Solution3 {

		public int arraySum(int[] array) throws ExecutionException, InterruptedException {
			ForkJoinPool pool = new ForkJoinPool();
			ForkJoinTask<Integer> submit = pool
					.submit(new SumArrayTask(array, 0, array.length - 1));
			return submit.get();
		}

		static class SumArrayTask extends RecursiveTask<Integer> {

			@Override
			protected Integer compute() {
				System.out.println(Thread.currentThread().getName() + " - " + left + "; " + right);
				if (left == right) {
					return array[left];
				}
				if (right - left == 1) {
					return array[right] + array[left];
				}
				int mid = (left + right) / 2;
				SumArrayTask leftTask = new SumArrayTask(array, left, mid);
				SumArrayTask rightTask = new SumArrayTask(array, mid + 1, right);
				leftTask.fork();
				rightTask.fork();
				return leftTask.join() + rightTask.join();
			}

			private final int[] array;
			private final int left;
			private final int right;

			public SumArrayTask(int[] array, int left, int right) {
				this.array = array;
				this.left = left;
				this.right = right;
			}
		}
	}
}
