package BinarySearch;

/*
 * This Binary Search does logn worst case
 * Overall 3 comparisons.
 * Can we reduce this
 */
public class GenericBinarySearch {
	static public int binarySearchGeneric(int[] a, int element) {
		int start = 0;
		int end = a.length - 1;
		int mid = 0;
		if (a.length == 0)
			return -1;
		while (start <= end) {
			mid = start + (end - start) / 2;

			if (a[mid] == element) // Comparison 1
				return mid;
			else if (a[mid] > element) // Comparison 2
				end = mid - 1;
			else
				// Comparison 3
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] num = { 5, 15, 45, 65, 455 };
		int element = 154;
		System.out.print(binarySearchGeneric(num, element));
	}
}
