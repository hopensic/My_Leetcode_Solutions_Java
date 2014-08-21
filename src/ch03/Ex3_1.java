package ch03;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import util.list_stack_queue.DataUtil;
import util.list_stack_queue.DataUtil.CanBeRepeat;
import util.list_stack_queue.DataUtil.Order;

public class Ex3_1 {

	public static void main(String[] args) {
		int[] l_array = DataUtil.makeIntArray(Order.ASCEND);
		int[] p_array = DataUtil.makeIntArray(4, Order.ASCEND, CanBeRepeat.NO_REPEAT, 10);

		List listL = Arrays.asList(ArrayUtils.toObject(l_array));
		List listP = Arrays.asList(ArrayUtils.toObject(p_array));
		DataUtil.print(listL);
		System.out.println();
		DataUtil.print(listP);
		System.out.println();
		printLots(listL, listP);

	}

	public static void printLots(List<Integer> L, List<Integer> P) {
		int lenL = L.size();
		int lenP = P.size();
		if (lenL == 0)
			throw new IllegalStateException("the length of L is 0");
		if (lenP == 0)
			throw new IllegalStateException("the length of P is 0");
		if (lenL - 1 < P.get(0))
			return;

		int i;
		for (i = lenP - 1; i >= 0; i--) {
			if (lenL - 1 >= P.get(i))
				break;
		}
		for (int j = 0; j < i + 1; j++) {
			System.out.print(L.get(P.get(j)) + "->");
		}

	}
}
