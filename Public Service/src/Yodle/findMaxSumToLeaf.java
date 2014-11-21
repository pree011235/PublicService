package Yodle;

import java.io.*;
import java.util.*;

/*
 * Logic: It does not make sense to go through all the possible paths from the 
 * root to the leaf nodes. Hence I start from the last row and I traverse up using
 * the max sum obtained so far.
 */
public class findMaxSumToLeaf {
	static int printMaxSum() {
		Scanner in = null;
		// Assuming the no of rows= 100
		int row = 100, count = 0;
		int[][] matrix = new int[row][row];

		try {
			in = new Scanner((new File("triangle.txt")));
			while (count < row) {
				for (int i = 0; i <= count; i++) {
					matrix[count][i] = in.nextInt();
				}
				count++;
			}
			// Calculating the maxSum leaf to root
			for (int r = matrix.length - 1; r > 0; r--) {
				for (int c = 0; c < r; c++) {
					matrix[r - 1][c] += Math
							.max(matrix[r][c], matrix[r][c + 1]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		in.close();
		return matrix[0][0];
	}

	public static void main(String[] args) {
		System.out.print(printMaxSum());
	}
}
