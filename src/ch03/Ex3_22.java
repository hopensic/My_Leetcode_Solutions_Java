package ch03;

import util.list_stack_queue.MyStack;

public class Ex3_22 {
	
	public static final char ADD = '+';
	public static final char SUBTRACT = '-';
	public static final char MULTIPLY = '*';
	public static final char WILDCARD = '*';

	public static void main(String[] args) {
		String str="6523+8*+3+*";
		System.out.println(getValue(str));
	}
	
	
	public static int getValue(String str) {
		char[] array = str.toCharArray();
		int len = array.length;
		MyStack<Character> stack = new MyStack<Character>();
		
		
		
		return 0;
	}

}
