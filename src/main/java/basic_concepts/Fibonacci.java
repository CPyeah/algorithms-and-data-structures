package basic_concepts;

public class Fibonacci {

	int solution(int n) {
		return f(n);
	}

	int f(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return f(n - 1) + f(n - 2);
	}

	// 1  1  2  3  5  8 ...
	void printFibonacciArray(int l) {
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
