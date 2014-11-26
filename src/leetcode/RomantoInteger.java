package leetcode;

import java.util.HashMap;

public class RomantoInteger {

	public static void main(String[] args) {

		System.out.println(new RomantoInteger().romanToInt("MDCCCXCIX"));

	}

	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		map.put('Z', 0);

		if (s == null || s.equals(""))
			return 0;
		char[] charArray = s.toCharArray();
		int len = charArray.length;
		if (len == 1)
			return map.get(charArray[0]);
		char q;
		char pre = 'Z';
		int sum = 0;
		for (int i = 0; i < len; i++) {
			q = charArray[i];
			sum += map.get(q);
			if (pre == 'Z')
				pre = q;
			else if (map.get(q) > map.get(pre)) {
				sum -= 2 * map.get(pre);
				pre = 'Z';
			} else
				pre = q;
		}
		return sum;
	}

}
