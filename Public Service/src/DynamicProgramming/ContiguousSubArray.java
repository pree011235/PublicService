package DynamicProgramming;

/*
 * Find the largest sum of a contiguous subarray in an array
 */
public class ContiguousSubArray {
	// Kandane's theorem: Only prints the largest sum
	static int kandane(int[] A) {
		int maxsofar = A[0];
		int maxendinghere = A[0];

		// OPT(i) = Max(Choose(i) + value(i), Don'tChoose(i))
		// OPT(i) = Max(i+OPT(i-1), OPT(i-1))

		for (int i = 1; i < A.length; i++) {
			maxendinghere = maxendinghere + A[i]; // Choose i

			if (maxendinghere > maxsofar) // Dont compare for all elements
				maxsofar = maxendinghere;
		}
		return maxsofar;
	}

	public static void main(String[] args) {
		int[] num = { -1, -4, -2, -7, -5 };
		System.out.println(kandane(num));

	}
}
