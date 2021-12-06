package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	int count;
	Map<Integer, Integer> cache = new HashMap<>();

	// normal
	public int solution(int n) {
		count = 0;
		int r = f(n);
		System.out.println(count);
		return r;
	}

	// with cache
	public int solution2(int n) {
		count = 0;
		cache.clear();
		int r = f2(n);
		System.out.println(count);
		return r;
	}

	private int f2(int n) {
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		++count;
		int result;
		if (n == 1 || n == 2) {
			result =  1;
		} else {
			result = f2(n - 1) + f2(n - 2);
		}
		cache.put(n, result);
		return result;
	}

	int f(int n) {
		++count;
		if (n == 1 || n == 2) {
			return 1;
		}
		return f(n - 1) + f(n - 2);
	}

	// 1  1  2  3  5  8 ...
	public void printFibonacciArray(int l) {
		int p1 =1,p2=1;
		for (int i = 1; i < l; i++) {
			if (i == 1 || i == 2) {
				System.out.print(1 + ", ");
			} else {
				int n = p1 + p2;
				System.out.print(n + ", ");
				p1 = p2;
				p2 = n;
			}
		}
	}

}
