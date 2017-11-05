package leetcode;

import tools.P;

public class IntegerBreak2 {
	static int arr[] = new int[9];
	static {
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		arr[5] = 6;
		arr[6] = 9;
		arr[7] =12;
		arr[8] = 18;
	}

	public static void main(String[] args) {
		P.lnrint(new IntegerBreak2().integerBreak(27));

	}

	public int integerBreak(int n) {

		if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		}
		if (n > 3 && n < 9)
			return arr[n];

		return (int) getNum(n);
	}

	private static double getNum(int n) {
		if (n < 7)
			return arr[n];
		else {
			int remainder = n % 2;
			int a = n / 2;
			if (remainder == 0) {
				return Math.pow(getNum(a), 2);
			} else {
				return getNum(a) * getNum(a + 1);
			}
		}
	}

}
