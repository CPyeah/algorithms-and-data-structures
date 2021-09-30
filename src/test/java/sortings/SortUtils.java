package sortings;

import java.util.Arrays;
import java.util.Random;

public class SortUtils {

	public static int[] getRandomArray() {
		Random random = new Random();
		int c = 10;
		int[] array = new int[10];
		for (int i = 0; i < c; i++) {
			array[i] = random.nextInt(15);
		}
		return array;
	}

	public static int[] sortArray(int[] array) {
		int[] newArray = Arrays.copyOf(array, array.length);
		Arrays.sort(newArray);
		return newArray;
	}

}
