package ch03;

import java.util.ArrayList;

public class Ex3_2 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		ArrayList list2 = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list.addAll(list2);
		System.out.println("");
		
	}

}
