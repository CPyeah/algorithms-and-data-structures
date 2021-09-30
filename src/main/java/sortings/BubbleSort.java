package sortings;

public class BubbleSort {

	public void solution(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				cas(array, j, j + 1);
			}
		}
	}

	private void cas(int[] array, int l, int r) {
		if (array[l] > array[r]) {
			int t = array[l];
			array[l] = array[r];
			array[r] = t;
		}
	}

}
