package SetOperation;

import java.util.*;

public class Set1 {
	public static void main(String[] args){
		Set<String> a = new HashSet<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		a.add("D");

		Set<String> b = new HashSet<String>();
		b.add("A");
		b.add("B1");
		b.add("C1");
		b.add("D1");

		Set<String> union = new HashSet<String>();
		union.addAll(a);
		union.addAll(b);
		for(String s: union)
			System.out.println(s);
	}
}
