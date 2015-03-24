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
		String str = "/**//**/(()))";
		deal(str);

	}

	public static void deal(String str) {

		boolean isBalanced = true;
		char[] array = str.toCharArray();
		int len = array.length;
		MyStack<Character> stack = new MyStack<Character>();
		char previous = '\0';
		char pop1;
		char pop2;

		for (int i = 0; i < len; i++) {
			if (!isBalanced) {
				break;
			}
			switch (array[i]) {
			case SLASH:
				if (previous == WILDCARD) {
					pop2 = stack.pop();
					pop1 = stack.pop();
					if (pop2 != WILDCARD || pop1 != SLASH) {
						isBalanced = false;
					}
				} else {
					stack.push(SLASH);
				}
				previous = SLASH;
				break;
			case WILDCARD:
				if (previous == SLASH) {
					stack.push(WILDCARD);
				}
				previous = WILDCARD;
				break;
			case LEFT_PARENTHESES:
				stack.push(LEFT_PARENTHESES);
				break;
			case RIGHT_PARENTHESES:
				if (stack.size() == 0) {
					isBalanced = false;
					break;
				}
				if (stack.pop() != LEFT_PARENTHESES) {
					isBalanced = false;
				}
				break;
			default:
				continue;
			}
		}

		if (stack.size() > 0)
			System.out.println("the expression is invalid");
		else {
			if (isBalanced)
				System.out.println("the expression is valid");
			else
				System.out.println("the expression is invalid");
		}
	}

}
