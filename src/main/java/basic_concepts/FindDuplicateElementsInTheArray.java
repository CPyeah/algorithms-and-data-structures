package basic_concepts;

import java.util.HashSet;
import org.apache.commons.lang3.ArrayUtils;

/**
 * find duplicate elements in the array
 */
public class FindDuplicateElementsInTheArray {

	// O(n^2)
	// 循环
	public int[] solution1(int[] array) {
		int[] duplicates = {};
		for (int i = 0; i < array.length - 1; i++) {
			int index = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int j_index = array[j];
				if (index == j_index) {
					duplicates = ArrayUtils.add(duplicates, index);
					break;
				}
			}
		}
		return duplicates;
	}

	// O(n)
	// use hash
	public int[] solution2(int[] array) {
		HashSet<Integer> singly = new HashSet<>();
		int[] duplicates = {};
		for (int index : array) {
			if (singly.contains(index)) {
				duplicates = ArrayUtils.add(duplicates, index);
			} else {
				singly.add(index);
			}
		}
		return duplicates;
	}
}
