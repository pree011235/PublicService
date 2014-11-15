package MinStack;

import java.util.*;

/*
 * Code and methods for us lesser mortals out there
 * Truly O of 1 space
 */
public class MinStack2 {
	private final Stack<Integer> minStack = new Stack<Integer>();
	private int minVal;

	public void push(int x) {
		minStack.push(x);
		if (minVal >= x) {
			minVal = x;
		}
	}

	public void pop() {
		int popped = minStack.pop();
		if (popped == minVal) {
			minStack.pop();
//			minVal = minStack.min(minVal);
		}
	}

//	int min(int currMin) {
//		if(minStack.size() == 0)
//			return minVal;
//	}

	public int top() {
		if (!minStack.isEmpty())
			return minStack.peek();
		return 0;
	}

	public int getMin() {
		if (!minStack.isEmpty())
			return minVal;
		return 0;
	}
}
