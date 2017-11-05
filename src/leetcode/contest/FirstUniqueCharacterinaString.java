package leetcode.contest;

import tools.P;

public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
		String s = "loveleetcode";
		P.lnrint(new FirstUniqueCharacterinaString().firstUniqChar(s));

	}

	public int firstUniqChar(String s) {
		int arr[] = new int[26];
		int len = s.length();
		for (int i = 0; i < len; i++) {
			arr[(s.charAt(i) - 'a')]++;
		}
		for (int i = 0; i < len; i++) {
			if (arr[(s.charAt(i) - 'a')] == 1)
				return i;
		}
		return -1;
	}

}
