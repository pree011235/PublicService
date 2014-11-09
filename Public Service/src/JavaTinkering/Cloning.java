package JavaTinkering;

/*
 * Examines the relation between shallow vs deep vs lazy copying in Java
 */
class Obj implements Cloneable {
	int a;

	public Obj(int a1) {
		this.a = a1;
	}

	@Override
	public Obj clone() throws CloneNotSupportedException {

		return (Obj) super.clone();
	}
}

class B {
	int b1;
}

class A implements Cloneable {
	int a;
	B b = new B();

	@Override
	public A clone() throws CloneNotSupportedException {
		return (A) super.clone();
	}
}

public class Cloning {
	static int[] a;

	public static void main(String[] args) throws CloneNotSupportedException {
		// doShallowCopy();
		// testClone();
		// moreClone();
		A a1 = new A();
		a1.a = 50;
		a1.b.b1 = 500;

		A a2 = a1.clone();

		System.out.println(a1.a + "\t" + a2.a);
		System.out.println(a1.b.b1 + "\t" + a2.b.b1);

		a1.a = 150;
		a1.b.b1 = 1500;

		System.out.println(a1.a + "\t" + a2.a);
		System.out.println(a1.b.b1 + "\t" + a2.b.b1);

	}

	static void moreClone() throws CloneNotSupportedException {
		// Shallow copy
		Obj[] one = new Obj[4];

		Obj a1 = new Obj(1);
		Obj a2 = new Obj(2);
		Obj a3 = new Obj(3);

		one[0] = a1;
		one[1] = a2;
		one[2] = a3;
		one[3] = (Obj) a1.clone();

		// one[3] = (Obj) a1.clone();
		Obj[] copy = one.clone();

		one[0].a = 999;

		for (Obj o : copy)
			System.out.println(o.a);
	}

	static int[] shallowCopy(int[] b) {
		a = b;
		b[0] = 455;
		return a;
	}

	static void doShallowCopy() {
		int[] b = { 1, 2, 3, 4 };
		shallowCopy(b);
		for (Integer i : b) {
			System.out.println(i);
		}
	}

	static void testClone() {
		int[] b = { 1, 2, 3, 4 };
		a = b.clone();
		b[0] = 99;
		for (Integer i : a) {
			System.out.println(i);
		}
	}

}
