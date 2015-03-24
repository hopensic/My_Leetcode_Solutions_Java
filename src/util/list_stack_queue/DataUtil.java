package util.list_stack_queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public final class DataUtil {

	private static Random random = new Random();
	private static final int DEFAULT_SIZE = 10;
	private static final int DEFAULT_MAX_NUM = 100;
	private static final Order DEFAULT_ORDER = Order.RANDOM;
	private static final CanBeRepeat DEFAULT_REPEAT = CanBeRepeat.CAN_REPEAT;

	public enum Order {
		RANDOM, ASCEND, DESCEND
	}

	/**
	 * 
	 * If the number produced by the methods could be the same<br/>
	 * 是否可以重复
	 * 
	 */
	public enum CanBeRepeat {
		CAN_REPEAT, NO_REPEAT
	}

	public static <T> void print(List<T> list) {
		Iterator<T> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + "->");
	}

	public static void printIntArray(int[] array) {
		for (int i : array)
			System.out.print(i + ",");
	}

	/**
	 * Default method for construct a int array <br/>
	 * 默认构造方法 ，构造一个默认的int数组
	 * 
	 */
	public static int[] makeIntArray() {
		return makeIntArray(DEFAULT_SIZE, DEFAULT_ORDER, DEFAULT_REPEAT, DEFAULT_MAX_NUM);
	}

	public static int[] makeIntArray(int size) {
		return makeIntArray(size, DEFAULT_ORDER, DEFAULT_REPEAT, DEFAULT_MAX_NUM);
	}

	public static int[] makeIntArray(Order orderflag) {
		return makeIntArray(DEFAULT_SIZE, orderflag, DEFAULT_REPEAT, DEFAULT_MAX_NUM);
	}

	public static int[] makeIntArray(CanBeRepeat cansame) {
		return makeIntArray(DEFAULT_SIZE, DEFAULT_ORDER, cansame, DEFAULT_MAX_NUM);
	}

	public static int[] makeIntArray(int size, Order orderflag) {
		return makeIntArray(size, orderflag, DEFAULT_REPEAT, DEFAULT_MAX_NUM);
	}

	public static int[] makeIntArray(int size, Order orderflag, int maxnumber) {
		return makeIntArray(size, orderflag, CanBeRepeat.CAN_REPEAT, maxnumber);
	}

	public static int[] makeIntArray(int size, Order orderflag, CanBeRepeat canSame, int maxNum) {
		int[] array = new int[size];
		switch (canSame) {
		case CAN_REPEAT:
			for (int i = 0; i < size; i++) {
				array[i] = random.nextInt(maxNum);
			}
			break;
		case NO_REPEAT:
			Set<Integer> set = new HashSet<Integer>();
			while (set.size() < size) {
				set.add(random.nextInt(maxNum));
			}
			Object[] arr = set.toArray();
			Integer[] s = new Integer[size];
			for (int i = 0; i < size; i++)
				s[i] = (Integer) arr[i];
			array = ArrayUtils.toPrimitive(s);
			break;
		}

		switch (orderflag) {
		case ASCEND:
			Arrays.sort(array);
			break;
		case DESCEND:
			Arrays.sort(array);
			int half = size / 2;
			int tmp;
			for (int i = 0; i < half; i++) {
				tmp = array[size - i - 1];
				array[size - i - 1] = array[i];
				array[i] = tmp;
			}
			break;
		default:
			break;
		}

		return array;
	}

	public static void main(String[] args) {
		// int[] array = makeIntArray(Order.DESCEND);
		// printIntArray(array);
	}

}
