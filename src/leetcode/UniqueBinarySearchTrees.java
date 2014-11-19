package leetcode;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTrees().numTrees(4));

	}

	public int numTrees(int n) {
		int a[] = new int[1000];
		a[0] = 1;
		a[1] = 1;
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += a[j] * a[i - j - 1];
			}
			a[i] = sum;
		}
		return a[n];
	}

}
