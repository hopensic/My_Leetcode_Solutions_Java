package leetcode.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tools.P;

public class LexicographicalNumbers5 {

	public static void main(String[] args) {
		int n = 8888888;
		new LexicographicalNumbers5().lexicalOrder(n);

	}

	public List<Integer> lexicalOrder(int n) {
		long time01 = System.currentTimeMillis();
		if (n < 10) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				list.add(i + 1);
			return list;
		}

		List<Integer> list = new ArrayList<Integer>(n);
		Stack<Integer> stack = new Stack<Integer>();
		int tmp;
		for (int i = 1; i < 10; i++) {
			stack.add(i);
			while (!stack.isEmpty()) {
				tmp = stack.pop();
				// P.lnrint(tmp);
				if (tmp <= n)
					list.add(tmp);
				else
					continue;
				int t = tmp * 10;
				int tt = tmp * 10 + 10;
				if (t <= n)
					for (int j = tt - 1; j >= t; j--)
						stack.push(j);
				// P.lnrint("stack:" + stack);
				// P.lnrint("list:" + list);
			}
		}
		long time02 = System.currentTimeMillis();
		P.lnrint("--time:" + (time02 - time01));
		// P.lnrint("--result:" + list);
		P.lnrint("--size:" + list.size());

		return list;
	}

}
