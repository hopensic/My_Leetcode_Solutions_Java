package leetcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class N_Queens {
	public int NUM;
	public BitSet testBitset;
	List<String[]> list = new ArrayList<String[]>();
	BitSet[] array;

	public static void main(String[] args) {
		new N_Queens().solveNQueens(8);

	}

	public List<String[]> solveNQueens(int n) {
		NUM = n;
		testBitset = new BitSet(n);
		array = new BitSet[n];
		for (int i = 0; i < n; i++)
			array[i] = new BitSet(n);
		begin(0);
		return list;
	}

	private void begin(int level) {
		int i = 0;
		for (i = 0; i < NUM; i++) {
			if (isValid(i, level)) {
				testBitset.set(i);

				if (level == NUM - 1) {
					String[] strs = new String[NUM];
					for (int h = 0; h < NUM; h++) {
						int r = array[h].nextSetBit(0);
						StringBuilder sb = new StringBuilder();
						for (int j = 0; j < NUM; j++)
							sb.append(j == r ? "Q" : ".");
						strs[h] = sb.toString();
					}
					list.add(strs);
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
