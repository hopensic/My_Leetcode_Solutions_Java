package ch03;

import util.list_stack_queue.MyStack;

public class Ex3_22 {

	public static final char ADD = '+';
	public static final char SUBTRACT = '-';
	public static final char MULTIPLY = '*';
	public static final char DIVIDE = '/';

	public static void main(String[] args) {
		String str = "6523+8*+3+*";
		System.out.println(getValue(str));
	}

	public static String getValue(String str) {
		char[] array = str.toCharArray();
		int len = array.length;
		String o1, o2, tmp;

		MyStack<String> stack = new MyStack<String>();
		for (int i = 0; i < len; i++) {
			tmp = String.valueOf(array[i]);
			switch (array[i]) {
			case ADD:
				o1 = stack.pop();
				o2 = stack.pop();
				stack.push((Integer.parseInt(o1) + Integer.parseInt(o2)) + "");
				break;
			case SUBTRACT:
				o1 = stack.pop();
				o2 = stack.pop();
				stack.push((Integer.parseInt(o1) - Integer.parseInt(o2)) + "");
				break;
			case MULTIPLY:
				o1 = stack.pop();
				o2 = stack.pop();
				stack.push((Integer.parseInt(o1) * Integer.parseInt(o2)) + "");
				break;
			case DIVIDE:
				o1 = stack.pop();
				o2 = stack.pop();
				stack.push((Integer.parseInt(o1) * Integer.parseInt(o2)) + "");
				break;
			default:
				stack.push(tmp);
			}
		}
		return stack.pop();
	}
}
