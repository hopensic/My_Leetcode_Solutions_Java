package leetcode;

import tools.P;

public class UniquePaths {

	public static void main(String[] args) {
		P.lnrint(new UniquePaths().uniquePaths(95, 95));
	}

	public int uniquePaths(int m, int n) {
		int min = Math.min(m, n);
		if (min == 1)
			return 1;
		int max = Math.max(m, n) + 1;
		int array[][] = new int[max][max];
		for (int i = 1; i < max; i++)
			array[1][i] = array[i][1] = 1;

		for (int i = 2; i < max; i++)
			for (int j = 1; j <= i; j++) {
				if (j == 1)
					continue;
				if (i == j)
					array[i][i] = 2 * array[i][i - 1];
				else
					array[i][j] = array[i][j - 1] + array[i - 1][j];
			}

		return array[max - 1][min];
	}

}
