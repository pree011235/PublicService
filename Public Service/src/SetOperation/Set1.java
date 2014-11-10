package SetOperation;

import java.util.*;

public class Set1 {
	public static void main(String[] args) {
		Set<String> a = new HashSet<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		a.add("D");

		Set<String> b = new HashSet<String>();
		b.add("A");
		b.add("B1");
		b.add("C1");
		b.add("D");

		Set<String> union = new HashSet<String>();
		union.addAll(a);
		union.addAll(b);
//		for (String s : union)
//			System.out.println(s);

		Set<String> intersection = new HashSet<String>();
		intersection.addAll(a);
		intersection.retainAll(b);
//		for (String s : intersection)
//			System.out.println(s);

		/*
		 * Unionr minus intersections is the symmetric diff
		 */
		Set<String> minus = new HashSet<String>();
		minus.addAll(union);
		minus.removeAll(intersection);
		for (String s : minus)
			System.out.println(s);

	}
}
