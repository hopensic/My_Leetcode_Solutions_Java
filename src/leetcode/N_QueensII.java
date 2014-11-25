package leetcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class N_QueensII {
	public int NUM;
	public BitSet testBitset;
	List<String[]> list = new ArrayList<String[]>();
	BitSet[] array;
	int sum = 0;

	public static void main(String[] args) {
		System.out.println(new N_QueensII().totalNQueens(8));

	}

	public int totalNQueens(int n) {
		NUM = n;
		testBitset = new BitSet(n);
		array = new BitSet[n];
		for (int i = 0; i < n; i++)
			array[i] = new BitSet(n);
		begin(0);
		return sum;

	}

	private void begin(int level) {
		int i = 0;
		for (i = 0; i < NUM; i++) {
			if (isValid(i, level)) {
				testBitset.set(i);

				if (level == NUM - 1) {
					sum++;
					testBitset.clear(i);
					array[level].clear(i);
					break;
				} else {
					begin(level + 1);
					testBitset.clear(i);
					array[level].clear(i);
				}
			}
		}
	}

	private boolean isValid(int col, int level) {
		array[level].set(col);
		array[level].and(testBitset);
		if (array[level].nextSetBit(0) > -1) {
			array[level].clear();
			return false;
		} else
			array[level].set(col);
		for (int j = 0; j < level; j++) {
			int comparedX = j + 1;
			int comparedY = array[j].nextSetBit(0) + 1;

			if (Math.abs(comparedX - (level + 1)) == Math.abs(comparedY
					- (col + 1))) {
				array[level].clear();
				return false;
			}

		}
		return true;
	}
}
