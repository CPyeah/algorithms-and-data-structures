package jvm;

public class JHSDB_TestCase {

	static class Test {

		static ObjectHolder staticObj = new ObjectHolder();
		ObjectHolder instanceObj = new ObjectHolder();

		void foo() throws InterruptedException {
			ObjectHolder localObj = new ObjectHolder();
			System.out.println("done"); // 这里设一个断点
			Thread.sleep(100000);
		}
	}

	private static class ObjectHolder {

	}

	public static void main(String[] args) throws InterruptedException {
		Test test = new JHSDB_TestCase.Test();
		test.foo();
	}

}
