package Comparisons;

import java.util.*;

/*
 * Implements a comparator
 * => Override a compare(Obj1, Obj2)
 * Object to be sorted doesn't need to implement the comparator
 * => Why? As we can pass the comparator while Collections.sort(list, comparator)
 */
class Obj {
	int a;
	String s;

	Obj(int a, String s) {
		this.a = a;
		this.s = new String(s);
	}
}

class newComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		Obj a0 = (Obj) arg0;
		Obj a1 = (Obj) arg1;

		return (a0.a == a1.a) ? 0 : ((a0.a > a1.a) ? +1 : -1);
	}
}

class newComparatorString implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		Obj a0 = (Obj) arg0;
		Obj a1 = (Obj) arg1;

		return (a0.s.hashCode() == a1.s.hashCode()) ? 0
				: ((a0.s.hashCode() > a1.s.hashCode()) ? +1 : -1);
	}
}

public class ComparatorImplementor {
	public static void main(String[] args) {
		ArrayList<Obj> aList = new ArrayList<Obj>();
		Obj a1 = new Obj(5, "A");
		Obj a2 = new Obj(15, "B");
		Obj a3 = new Obj(-5, "C");

		aList.add(a1);
		aList.add(a2);
		aList.add(a3);

		Collections.sort(aList, new newComparator());
		for (Obj a : aList) {
			System.out.println(a.a + "\t" + a.s);
		}

		Collections.sort(aList, new newComparatorString());
		for (Obj a : aList) {
			System.out.println(a.a + "\t" + a.s);
		}

	}
}
