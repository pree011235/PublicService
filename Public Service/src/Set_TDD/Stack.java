package Set_TDD;

import java.util.*;

public class Stack<T> {
	ArrayList<T> stack = new ArrayList<T>();

	public T pop() {
		if (stack.size() == 0)
			return null;
		else {
			T popped = stack.remove(stack.size()-1);
			return popped;
		}
	}

	public void push(T t) {
		stack.add(t);
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int size() {
		return stack.size();
	}
}
