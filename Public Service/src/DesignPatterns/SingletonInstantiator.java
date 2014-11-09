package DesignPatterns;

/*
 * Thread unsafe implementation of Singleton
 * Uses lazy initialization
 */
//Final: SingletonThreadUnsafe can't be subclassed
final class SingletonThreadUnsafe {
	private static SingletonThreadUnsafe SingletonThreadUnsafeInstance = null;

	private SingletonThreadUnsafe() {
		// Exists only to defeat instantiation
	}

	public static SingletonThreadUnsafe getInstance() {
		if (SingletonThreadUnsafeInstance == null)
			SingletonThreadUnsafeInstance = new SingletonThreadUnsafe();
		return SingletonThreadUnsafeInstance;
	}
}

public class SingletonInstantiator {
	public SingletonInstantiator() {
		// Can't do this
		// SingletonThreadUnsafe SingletonThreadUnsafeInstance = new
		// SingletonThreadUnsafe();
		//Hence,
		SingletonThreadUnsafe SingletonThreadUnsafeInstance= SingletonThreadUnsafe.getInstance();
	}
}