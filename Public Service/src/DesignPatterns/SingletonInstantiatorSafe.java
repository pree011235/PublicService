package DesignPatterns;

/*
 * Using Synchronized
 */
final class SingletonThreadSafe {
	private static SingletonThreadSafe SingletonThreadsafeInstance = null;

	private SingletonThreadSafe() {
		// Exists only to defeat instantiation
	}

	synchronized public static SingletonThreadSafe getInstance() {
		if (SingletonThreadsafeInstance == null)
			SingletonThreadsafeInstance = new SingletonThreadSafe();
		return SingletonThreadsafeInstance;
	}
}

public class SingletonInstantiatorSafe {
	public SingletonInstantiatorSafe() {
		// Can't do this
		// SingletonThreadUnsafe SingletonThreadUnsafeInstance = new
		// SingletonThreadUnsafe();
		// Hence,
		SingletonThreadUnsafe SingletonThreadUnsafeInstance = SingletonThreadUnsafe
				.getInstance();
	}
}