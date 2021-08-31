package model;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

	private List<T> context;

	public MyStack() {
		context = new ArrayList<>();
	}

	public void push(T item) {
		context.add(item);
	}

	public T pop() {
		if (context == null || context.size() == 0) {
			return null;
		}
		T t = context.get(context.size() - 1);
		context.remove(context.size() - 1);
		return t;
	}


}
