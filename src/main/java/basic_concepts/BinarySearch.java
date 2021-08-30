package basic_concepts;

public class BinarySearch {

	public int solution(int[] array, int target) {
		if (target < array[0] || target > array[array.length-1]) {
			return -1;
		}
		int leftIndex = 0, rightIndex = array.length -1;
		while (true) {
			if (rightIndex - leftIndex <= 1) {
				return -1;
			}
			int midIndex = (leftIndex + rightIndex) / 2;
			if (target == array[midIndex]) {
				return midIndex;
			} else if(target == array[leftIndex]) {
				return leftIndex;
			} else if (target == array[rightIndex]) {
				return rightIndex;
			} else {
				if (target > array[midIndex]) {
					leftIndex = midIndex;
				} else {
					rightIndex = midIndex;
				}
			}
		}
	}

}
