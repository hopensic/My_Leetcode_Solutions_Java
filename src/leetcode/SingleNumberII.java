package leetcode;

public class SingleNumberII {

	public static void main(String[] args) {
		// int[] A = {1,2,1,2,3,4,3,5,5};
		// System.out.println(new SingleNumberII().singleNumber(A));
		System.out.println(1 << 4);

	}

	public int singleNumber(int[] A) {
		int n = A.length;

		int result = 0;
		for (int i = 0; i < n; i++) {
			result ^= A[i];
		}
		return result;
	}
}
