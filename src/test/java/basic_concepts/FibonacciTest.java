package basic_concepts;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import recursion.Fibonacci;

public class FibonacciTest {

	Fibonacci fibonacci = new Fibonacci();

	@Test
	public void solution() {
		Assert.assertEquals(1, fibonacci.solution(1));
		Assert.assertEquals(2, fibonacci.solution(3));
		Assert.assertEquals(5, fibonacci.solution(5));
		Assert.assertEquals(34, fibonacci.solution(9));
	}

	@Test
	public void solution2() {
//		Assert.assertEquals(1, fibonacci.solution2(1));
//		Assert.assertEquals(2, fibonacci.solution2(3));
//		Assert.assertEquals(5, fibonacci.solution2(5));
		Assert.assertEquals(34, fibonacci.solution2(9));
	}

	@Test
	public void printFibonacci() {
		fibonacci.printFibonacciArray(10);
	}

	/**
	 * 1
	 * 1
	 *
	 * 1
	 * 1
	 *
	 * 3
	 * 3
	 *
	 * 5
	 * 4
	 *
	 * 9
	 * 5
	 *
	 * 15
	 * 6
	 *
	 * 25
	 * 7
	 *
	 * 41
	 * 8
	 *
	 * 67
	 * 9
	 *
	 * 109
	 * 10
	 */
	@Test
	@Ignore
	public void checkTimeComplexity() {
		for (int i = 1; i <= 10; i++) {
			fibonacci.solution(i);
			fibonacci.solution2(i);
			System.out.println();
		}
	}


}