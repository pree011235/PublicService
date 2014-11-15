package BinarySearch;

public class BinarySearchImproved {
	static int impovedBS(int[] num, int elem) {
		int start = 0;
		int end = num.length;
		int mid = 0;

		while (end - start > 1) {
			mid = start + (end - start) / 2;

			if (num[mid] <= elem)
				start = mid;
			else
				end = mid;
		}
		if (num[start] == elem)
			return start;
		else
			return -1;
	}

	public static void main(String[] args) {
		int[] num = { 5, 15, 45, 65, 70 };
		int element = 5;
		System.out.print(impovedBS(num, element));
	}
}
