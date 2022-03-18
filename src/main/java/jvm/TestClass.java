package jvm;

import java.io.Serializable;

public class TestClass implements Serializable, Runnable {

	private int m;

	public int inc() {
		return m + 1;
	}

	@Override
	public void run() {
		inc();
	}
}
