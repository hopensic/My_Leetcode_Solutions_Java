package leetcode;

import tools.P;

public class IntegerBreak {
	int a[] = new int[58];

	public static void main(String[] args) {
		P.lnrint(new IntegerBreak().integerBreak(27));

	}

	public int integerBreak(int n) {
		a[2] = 2;
		a[3] = 3;
		a[4] = 4;
		a[5] = 6;
		a[6] = 9;
		if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		}
		if (n > 3 && n < 7)
			return a[n];
		for (int i = 7; i <= n; i++) {
			int rightBound = i / 2;
			int max = 0;
			for (int j = 2; j <= rightBound; j++) {
				int tmp = a[j] * a[i - j];
				if (tmp > max)
					max = tmp;
			}
			a[i] = max;
		}
		return a[n];
	}

}
