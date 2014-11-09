package Comparisons;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Please refer to Comparator.java
 * Here, the object has to implement Comparable
 * int compareTo(obj1)
 */
class Obj1 implements Comparable {
	int a;
	String s;

	Obj1(int a, String s) {
		this.a = a;
		this.s = new String(s);
	}

	@Override
	public int compareTo(Object arg0) {
		Obj1 o = (Obj1) arg0;
		return this.a == o.a ? 0 : (this.a > o.a ? +1 : -1);
	}
}

public class ComparableImplementor {
	public static void main(String[] args) {
		ArrayList<Obj1> aList = new ArrayList<Obj1>();
		Obj1 a1 = new Obj1(5, "A");
		Obj1 a2 = new Obj1(15, "B");
		Obj1 a3 = new Obj1(-5, "C");

		aList.add(a1);
		aList.add(a2);
		aList.add(a3);

		Collections.sort(aList);
		for (Obj1 a : aList) {
			System.out.println(a.a + "\t" + a.s);
		}
	}
}
