package MyIterator;

import java.util.Collection;
import java.util.Iterator;

public class MyCollection<T> implements Iterable<T> {

	Collection<T> mycollection;

	@Override
	public Iterator<T> iterator() {
		System.out.println("Hello");
		return (Iterator<T>) mycollection.iterator();
	}

}
