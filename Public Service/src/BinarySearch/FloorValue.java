package BinarySearch;

public class FloorValue {
	static int getFloorValue(int[] num, int elem) {
		int mid = 0;
		int start = 0;
		int end = num.length;
		if (elem < num[0]) //BC1
			return -1;
		while (end - start > 1) {
			mid = start + (end - start) / 2;

			if (num[mid] <= elem)
				start = mid;
			else
				end = mid;
		}
		return num[start];
	}

	public static void main(String[] args) {
		int[] num = { 5, 15, 45, 65, 70 };
		int element = 7;
		System.out.print(getFloorValue(num, element));
	}

}
