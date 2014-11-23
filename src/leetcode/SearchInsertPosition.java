package leetcode;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int A[] = { 1, 3, 5, 6 };
		System.out.println(new SearchInsertPosition().searchInsert(A, 0));
	}

	public int searchInsert(int[] A, int target) {
		int len = A.length;
		if (len == 0)
			return 0;
		else if (len == 1) {
			if (target <= A[0])
				return 0;
			else
				return 1;
		} else {
			if (target < A[0])
				return 0;
			if (target > A[len - 1])
				return len;

			int left = 0;
			int right = len;
			int mid = (0 + len) / 2;
			while (left <= right) {
				if (target == A[mid])
					return mid;
				else if (target > A[mid]) {
					left = mid + 1;
					mid = (left + right) / 2;
				} else {
					right = mid - 1;
					mid = (left + right) / 2;
				}
			}
			return left;
		}
	}
}
