package basic_concepts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParenthesisMatchingTest {

	ParenthesisMatching parenthesisMatching;

	@Before
	public void setUp() {
		parenthesisMatching = new ParenthesisMatching();
	}

	@Test
	public void solution() {
		Assert.assertTrue(parenthesisMatching.solution("{{()}}[]"));
		Assert.assertFalse(parenthesisMatching.solution("{{()}[}]"));
		Assert.assertFalse(parenthesisMatching.solution("{{()}}[])"));
		Assert.assertFalse(parenthesisMatching.solution("{{()}}[]{"));
		Assert.assertTrue(parenthesisMatching.solution("public int solution1(int n) {\n"
				+ "\t\tif (n <= 1) {\n"
				+ "\t\t\treturn 1;\n"
				+ "\t\t} else {\n"
				+ "\t\t\treturn n * solution1(n - 1);\n"
				+ "\t\t}\n"
				+ "\t}"));
	}
}