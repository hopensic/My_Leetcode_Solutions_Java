package leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(-2147483648));
		// System.out.println(Integer.parseInt("00100"));
	}

	public int reverse(int x) {
		if (x == 0)
			return 0;
		else if (x > 0)
			return temp(x + "", true);
		else
			return 0 - (temp(x + "", false));
	}

	private int temp(String a, boolean flag) {
		long o = Long.parseLong(a);
		if (o < 0)
			o = o * (-1);
		String s = o + "";
		StringBuilder sb = new StringBuilder();
		char[] array = s.toCharArray();
		int len = array.length;
		for (int i = len - 1; i >= 0; i--) {
			sb.append(array[i]);
		}

		o = Long.parseLong(sb.toString());
		if (flag) {
			if (o > 2147483647L)
				return 0;
			else
				return (int) o;
		} else {
			if (o > 2147483648L)
				return 0;
			else
				return (int) o;
		}
	}
}
