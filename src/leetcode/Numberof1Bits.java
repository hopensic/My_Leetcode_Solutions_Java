package leetcode;

public class Numberof1Bits {

	public static void main(String[] args) {
		System.out.println(new Numberof1Bits().hammingWeight(11));
	}

	public int hammingWeight(int n) {
		int num = 0;
		int tmp;
		if (n == 0)
			return 0;
		for (int i = 0; i < 32; i++) {
			tmp = 1 & n;
			if (tmp == 1)
				num++;
			n = n >> 1;
		}
		return num;
	}
}
