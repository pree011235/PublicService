package BinarySearch;

public class CeilValue {
	static int getCeilValue(int[] num, int elem) {
		int mid = 0;
		int start = -1;
		int end = num.length;

		while (end - start > 1) {
			mid = start + (end - start) / 2;

			if (num[mid] >= elem)
				end = mid;
			else
				start = mid;
		}
		return num[end];
	}

	public static void main(String[] args) {
		int[] num = { 5, 15, 45, 65, 70 };
		int element = 69;
		System.out.print(getCeilValue(num, element));
	}

}
