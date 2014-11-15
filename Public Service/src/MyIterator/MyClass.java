package MyIterator;

import java.util.Iterator;

/*
 * MyClass implements Iterable
 */

public class MyClass<T> {
	T t;

	void setT(T t) {
		this.t = t;
	}

	T getT() {
		return this.t;
	}
}
