package basic_concepts;

/**
 * 二分查找
 */
public class BinarySearch {

	/**
	 * loop
	 */
	public static class Solution1 {

		public int binarySearch(int[] arr, int key) {
			int left = 0;
			int right = arr.length -1;
			while (true) {
				if (key == arr[left]) {
					return left;
				} else if (key == arr[right]) {
					return right;
				} else if (left >= right) {
					return -1;
				}
				int mid = (left + right) / 2;
				if (key == arr[mid]) {
					return mid;
				} else if (key > arr[mid]) {
					left = mid;
					right --;
				} else {
					right = mid;
					left++;
				}
			}
		}

	}

	/**
	 * 递归
	 */
	public static class Solution2 {

		public int binarySearch(int[] arr, int key) {
			return binarySearch(arr, 0, arr.length-1, key);
		}

		public int binarySearch(int[] arr, int left, int right, int key) {
			if (key == arr[left]) {
				return left;
			} else if (key == arr[right]) {
				return right;
			}
			if (left >= right) {
				return -1;
			}
			int mid = (left + right) / 2;
			if (key == arr[mid]) {
				return mid;
			} else if (key > arr[mid]) {
				left = mid;
				right --;
				return 	binarySearch(arr, left, right, key);
			} else {
				right = mid;
				left++;
				return 	binarySearch(arr, left, right, key);
			}
		}

	}
}
