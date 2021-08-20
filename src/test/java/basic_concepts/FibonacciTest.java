package basic_concepts;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

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
	public void printFibonacci() {
		fibonacci.printFibonacciArray(10);
	}
}