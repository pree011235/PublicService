package MyIterator;

class Obj<T> extends MyClass<T> {
	T a;

}

public class Main {
	public static void main(String[] args) {
		Obj a = (Obj) new MyClass<Obj>();
		a.a = 55;

		Obj a1 = (Obj) new MyClass<Obj>();
		a1.a = 55;

		MyCollection<Obj> coll = new MyCollection<Obj>();
		coll.mycollection.add(a);
		coll.mycollection.add(a1);

		for (Obj o1 : coll) {
			System.out.println(o1.a);
		}
	}
}
