package BinarySearch;

public class FindDupCount {
	static int findRightIndex(int[] num, int key) {
		int start = -1;
		int end = num.length - 1;
		int mid = 0;

		while (end - start > 1) {
			mid = start + (end - start) / 2;

			if (num[mid] >= key)
				end = mid;
			else
				start = mid;
		}
		return end;
	}

	static int findLeftIndex(int[] num, int key) {
		int start = -1;
		int end = num.length - 1;
		int mid = 0;

		while (end - start > 1) {
			mid = start + (end - start) / 2;

			if (num[mid] <= key)
				start = mid;
			else
				end = mid;
		}
		return start;
	}

	public static void main(String[] args) {
		int[] num = { 0, 1, 1, 1, 1, 1, 4, 5 };
		int key = 0;

		if (num[0] > key || num[num.length - 1] < key)
			return;

		int right = findRightIndex(num, key);
		System.out.println(right);
		int left = findLeftIndex(num, key);
		System.out.println(left);

		if (num[right] == key && num[left] == key)
			if (right == left)
				System.out.print(right);
			else
				System.out.print(left - right + 1);
		else {
			if (num[right] != key && num[left] == key)
				System.out.print(left);
			if (num[right] == key && num[left] != key)
				System.out.print(right);
		}
	}
}
