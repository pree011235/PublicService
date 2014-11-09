package CollisionResolutionTechniques;

public class LinearProbing<Key, Value> {
	private int size = 300001;
	private Value[] value = (Value[]) new Object[size];
	private Key[] key = (Key[]) new Object[size];
	private int currSize;

	public int getHash(Key thiskey){
		return key.hashCode();
	}
	
	public Value put(Key thiskey, Value thisval) {
		int hash = thiskey.hashCode();
		for (int i = hash; key[i] != null; i = (i + 1) % size) {
			if (getHash(key[i]) == hash)
				break;
			key[i] = thiskey;
			value[i] = thisval;
		}
		currSize ++;
		return thisval;
	}

	public Value get(Key thiskey) {
		int hash = thiskey.hashCode();
		for (int i = hash; key[i] != null; i = (i + 1) % size) {
			if (getHash(key[i]) == hash)
				return value[i];
		}
		return null;
	}
	
	
}
