package basic_concepts;

import com.google.common.math.IntMath;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

	private final Factorial factorial = new Factorial();

	@Test
	public void solution1() {
		int n = new Random().nextInt(10);
		Assert.assertEquals(IntMath.factorial(n), factorial.solution1(n));
	}

	@Test
	public void solution2() {
		int n = new Random().nextInt(10);
		Assert.assertEquals(IntMath.factorial(n), factorial.solution2(n));
	}
}
