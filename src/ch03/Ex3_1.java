package ch03;

import java.util.ArrayList;

public class Ex3_1 {

	public static void main(String[] args) {
		ArrayList<Integer> L = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++)
			L.add(i + 1);
		ArrayList<Integer> P = new ArrayList<Integer>();
		P.add(7);
		P.add(13);
		P.add(14);
		P.add(16);
		printLots(L, P);

	}

	public static void printLots(ArrayList<Integer> L, ArrayList<Integer> P) {
		int lenL = L.size();
		int lenP = P.size();
		if (lenL == 0)
			throw new IllegalStateException("the length of L is 0");
		if (lenP == 0)
			throw new IllegalStateException("the length of P is 0");
		if (lenL - 1 < P.get(0))
			return;

		int lastIndexofP = -1;
		int i;
		for (i = lenP - 1; i >= 0; i--) {
			if (lenL - 1 >= P.get(i))
				break;
		}
		lastIndexofP = P.get(i);
		for (int j = 0; j < i + 1; j++) {
			System.out.print(L.get(P.get(j)) + ",");
		}

	}
}
