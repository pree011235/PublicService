package Trie;

import java.util.LinkedList;
import java.util.Queue;

/*
 * From SedgeWicks implementation
 * This implementation uses a  256 way trie
 * Wait, what!?! 
 */
public class Trie1<Value> {
	final private static int R = 256;

	private Node root; // For the root. Root's value is empty.
	private int N; // Number of keys in a trie

	private static class Node {
		private Object val;
		private Node[] next = new Node[R];
	}

	public Trie1() {

	}

	// Does this symbol table contain this key?
	public boolean contains(String key) {
		if (get(key) != null)
			return true;
		return false;
	}

	// If value exists for the key, it is returned
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	Node get(Node root, String key, int index) {
		if (root == null)
			return null;
		if (key.length() == index)
			return root;
		char c = key.charAt(index);
		return get(root.next[c], key, index + 1);
	}

	// Inserts the key, value pair into the symbol table. Overwrites the value
	// if the same key is present
	public void put(String key, Value value) {
		if (value == null)
			delete(key);
		else
			root = put(root, key, value, 0);
	}

	Node put(Node root, String key, Value value, int index) {
		if (root == null)
			root = new Node();
		if (index == key.length()) {
			if (root.val == null)
				N++; // Increase cur size of Trie
			root.val = value;
			return root;
		}
		char c = key.charAt(index);
		root.next[c] = put(root.next[c], key, value, index + 1);
		return root.next[c];
	}

	// Overwrite key of value is null -> delete the key if present
	void delete(String key) {
		root = delete(root, key, 0);
	}

	Node delete(Node root, String key, int d) {
		if (root == null)
			return null;
		if (d == key.length()) {
			if (root.val != null)
				N--;
			root.val = null;
		} else {
			char c = key.charAt(d);
			root.next[c] = delete(root.next[c], key, d + 1);
		}
		// Remove subtrie at root if it is not completely empty
		if (root.val != null)
			return root;

		for (char c = 0; c < R; c++) {
			if(root.next[c] != null){
				return root;
			}
		}
		return null;
	}

	// Prints size of trie
	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	// Returns all the keys in the trie as an iterable
	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	// Returns all the keys as an iterable, that start with prefix as Prefix
	Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> results = new LinkedList<String>();
		Node x = get(root, prefix, 0);
		collect(x, new StringBuilder(prefix), results);
		return results;
	}

	private void collect(Node x, StringBuilder prefix, Queue<String> results) {
		if (x == null)
			return;
		if (x.val != null)
			results.add(prefix.toString());
		for (char c = 0; c < R; c++) {
			prefix.append(c); // Forward track
			collect(x.next[c], prefix, results); // Add to Queue for prefix
													// combination
			prefix.deleteCharAt(prefix.length() - 1); // Backtrack
		}
	}

	public Iterable<String> keysThatMatch(String pattern) {
		Queue<String> results = new LinkedList<String>();
		collect(root, new StringBuilder(), pattern, results);
		return results;
	}

	private void collect(Node root, StringBuilder prefix, String pattern,
			Queue<String> results) {
		if (root == null)
			return;
		int d = prefix.length();
		if (d == pattern.length() && root.val != null)
			results.add(prefix.toString()); // When pattern and prefix match
											// exactly
		if (d == pattern.length())
			return; // Not an exact match so return empty string
		char c = pattern.charAt(d);
		if (c == '.') {
			/*
			 * If the current char is a period, check for all the other
			 * characters in the set which could make up the pattern after that
			 */
			for (char ch = 0; c < R; c++) {
				prefix.append(ch);
				collect(root.next[ch], prefix, pattern, results);
				prefix.deleteCharAt(prefix.length() - 1);
			}
		} else {
			/*
			 * Else continue
			 */
			prefix.append(c);
			collect(root.next[c], prefix, pattern, results);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}

	// returns the length of the longest string key in the subtrie
	// rooted at x that is a prefix of the query string,
	// assuming the first d character match and we have already
	public String longestPrefixof(String query) {
		int length = longestPrefixOf(root, query, 0, 0);
		return query.substring(length);
	}

	private int longestPrefixOf(Node root, String query, int d, int length) {
		if (root == null)
			return length;
		char curr = query.charAt(d);
		if (root.val != null)
			length = d;
		if (d == query.length())
			return length;
		return longestPrefixOf(root.next[curr], query, d + 1, length);
	}

}
