package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

public class SortUtils {

	public static int[] getRandomArray() {
		Random random = new Random();
		int c = 50;
		int[] array = new int[c];
		for (int i = 0; i < c; i++) {
			array[i] = random.nextInt(50);
		}
		System.out.println(Arrays.toString(array));
		return array;
	}

	public static int[] sortArray(int[] array) {
		int[] newArray = Arrays.copyOf(array, array.length);
		Arrays.sort(newArray);
		return newArray;
	}

}
