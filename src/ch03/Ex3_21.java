package ch03;

import util.list_stack_queue.MyStack;

public class Ex3_21 {
	public static final char SLASH = '/';
	public static final char WILDCARD = '*';
	public static final char LEFT_PARENTHESES = '(';
	public static final char RIGHT_PARENTHESES = ')';
	public static final char LEFT_BRACKET = '[';
	public static final char RIGHT_BRACKET = ']';
	public static final char LEFT_BRACE = '{';
	public static final char RIGHT_BRACE = '}';

	public static void main(String[] args) {
		String str = "/* */";

	}

	public void deal(String str) {
		char[] array = str.toCharArray();
		int len = array.length;
		MyStack<Character> stack = new MyStack<Character>();
		for (int i = 0; i < len; i++) {
			switch (array[i]) {
			case SLASH:

				break;

			default:
				continue;
			}
		}

	}

}
