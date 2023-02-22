package DataStructures;

public class Pair<T1, T2> {
	T1 key;
	T2 value;
	
	public Pair(T1 beginWord, T2 level) {
		key = beginWord;
		value = level;
		// TODO Auto-generated constructor stub
	}

	public T1 getKey() {
		return key;
	}

	public T2 getValue() {
	return value;
}

}