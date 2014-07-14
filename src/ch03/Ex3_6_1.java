package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import util.list_stack_queue.MyLinkedList.Node;

public class Ex3_6_1 {

	public static void main(String[] args) {
		int N = 5;
		int M = 2;
		// pass(M, N);
		josephus(N, M);

	}

	public static void josephus(int N, int M) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++)
			list.add(i + 1);

		int totalnum = N;
		int step = M % N;

		int temp = -1;
		ListIterator<Integer> listIterator = list.listIterator();
		for (int h = 0; h < N - 1; h++) {
			if (step <= totalnum / 2) {

				for (int i = 0; i < step; i++) {
					if (!listIterator.hasNext())
						listIterator = list.listIterator();
					temp = listIterator.next();
				}
				System.out.print(temp + ",");
				listIterator.remove();

			} else {
				for (int j = 0; j <= totalnum - step; j++) {
					if (!listIterator.hasPrevious())
						listIterator = list.listIterator(list.size());
					temp = listIterator.previous();
				}
				System.out.print(temp + ",");
				listIterator.remove();
			}
			totalnum--;
			step = M % totalnum == 0 ? totalnum : M % totalnum;

		}
	}

	public static void pass(int m, int n) {
		int i, j, mPrime, numLeft;
		ArrayList<Integer> L = new ArrayList<Integer>();
		for (i = 1; i <= n; i++)
			L.add(i);
		ListIterator<Integer> iter = L.listIterator();
		Integer item = 0;
		numLeft = n;
		mPrime = m % n;
		for (i = 0; i < n; i++) {
			mPrime = m % numLeft;
			if (mPrime <= numLeft / 2) {
				if (iter.hasNext())
					item = iter.next();
				for (j = 0; j < mPrime; j++) {
					if (!iter.hasNext())
						iter = L.listIterator();
					item = iter.next();
				}
			} else {
				for (j = 0; j < numLeft - mPrime; j++) {
					if (!iter.hasPrevious())
						iter = L.listIterator(L.size());
					item = iter.previous();
				}
			}
			System.out.print("Removed" + item + "");
			iter.remove();
			if (!iter.hasNext())
				iter = L.listIterator();
			System.out.println();
			for (Integer x : L)
				System.out.print(x + "");
			System.out.println();
			numLeft--;
		}
		System.out.println();
	}
}
