package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {
	Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

	public static void main(String[] args) {
		List list = new GenerateParentheses().generateParenthesis(7);
	}

	public List<String> generateParenthesis(int n) {
		String[] a = { "()" };
		String[] b = { "(())", "()()" };
		map.put(1, Arrays.asList(a));
		map.put(2, Arrays.asList(b));
		if (n <= 2)
			return map.get(n);
		for (int i = 3; i <= n; i++)
			covert(i);
		return map.get(n);
	}

	private void covert(int n) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		for (int h = 1; h < n + 1; h++) {
			s1.append("(");
			s2.append(")");
			List<String> list = new ArrayList<String>();
			for (int i = 1; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int x = 1; x <= i; x++) {
					sb.append("(");
				}
				for (int j = 1; j <= i; j++) {
					StringBuilder str = new StringBuilder();
					for (int g = 1; g <= j; g++)
						str.append(")");
					StringBuilder sb3 = new StringBuilder();
					sb3.append(sb).append(str);
					int y = n - i;
					List<String> tmpList = map.get(y);
					for (String s : tmpList) {
						StringBuilder sb2 = new StringBuilder();
						sb2.append(sb3).append(s);
						for (int p = 0; p < i - j; p++) {
							sb2.append(")");
						}
						list.add(sb2.toString());
					}

				}
			}
			list.add((new StringBuilder().append(s1).append(s2)).toString());
			if (h > 2)
				map.put(h, list);
		}
	}
}
