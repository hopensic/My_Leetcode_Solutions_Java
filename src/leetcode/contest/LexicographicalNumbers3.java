package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LexicographicalNumbers3 {

	public static void main(String[] args) {
		int n = 500000;
		List<Integer> list = new LexicographicalNumbers3().lexicalOrder(n);
//		 P.lnrint(list);
//		 P.lnrint(list.size());

	}

	public List<Integer> lexicalOrder(int n) {
		long time1 = System.currentTimeMillis();

		if (n < 10) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				list.add(i + 1);
			return list;
		}

		int map[] = new int[8];
		int mathMap[] = new int[8];
		map[1] = 1;
		map[2] = 10;
		map[3] = 100;
		map[4] = 1000;
		map[5] = 10000;
		map[6] = 100000;
		map[7] = 1000000;

		mathMap[1] = 10;
		mathMap[2] = 100;
		mathMap[3] = 1000;
		mathMap[4] = 10000;
		mathMap[5] = 100000;
		mathMap[6] = 1000000;
		mathMap[7] = 10000000;

		String s = String.valueOf(n);
		int len = s.length();
		char c = s.charAt(0);
		int single = (mathMap[len] - 1) / 9;
		int dSingle = (mathMap[len - 1] - 1) / 9;

		Set<String> set = new TreeSet<String>();

		if (c == '1') {
			List<Integer> listAll = new ArrayList<Integer>();
			Integer[] rightArray = new Integer[dSingle * (9 - (c - '0'))];
			int cI = c - '0';
			// left
			List<Integer> listLeft = new ArrayList<Integer>(n);
			set.add("1");
			for (int i = 1; i <= len - 1; i++) {
				double destJ = 0;
				int j = mathMap[i];
				if (i == len - 1) {
					destJ = n;
				} else {
					destJ = j + (mathMap[i]);
				}
				for (; j < destJ; j++) {
					set.add(String.valueOf(j));
				}
			}
			set.add(String.valueOf(n));
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				listLeft.add(Integer.parseInt(it.next()));
			}
			set.clear();
			// right

			set.add(String.valueOf(cI + 1));
			for (int i = 1; i <= len - 2; i++) {
				double destJ = 0;
				int j = mathMap[i] * (cI + 1);
				destJ = j + (mathMap[i]);
				for (; j < destJ; j++) {
					set.add(String.valueOf(j));
				}
			}
			it = set.iterator();
			int k = 0;
			while (it.hasNext()) {
				String nextStr = it.next();
				int tmplen = nextStr.length();
				int next = Integer.parseInt(nextStr);
				for (int i = 0, j = k; i < 9 - (c - '0'); i++, j = dSingle * i + k)
					rightArray[j] = next + map[tmplen] * i;
				k++;
			}
			set.clear();
			List<Integer> listRight = Arrays.asList(rightArray);
			listAll.addAll(listLeft);
			listAll.addAll(listRight);
			System.out.println(System.currentTimeMillis() - time1);
			return listAll;
		} else if (c == '9') {
			Integer[] leftArray = new Integer[single * ((c - '0') - 1)];
			List<Integer> listRight = new ArrayList<Integer>();
			List<Integer> listMiddle = new ArrayList<Integer>();
			List<Integer> listAll = new ArrayList<Integer>();

			set.add("1");
			for (int i = 1; i <= len - 1; i++) {
				double destJ = 0;
				int j = mathMap[i];
				destJ = 2 * j;
				for (; j < destJ; j++) {
					set.add(String.valueOf(j));
				}
			}

			// left
			Iterator<String> it = set.iterator();
			int k = 0;
			while (it.hasNext()) {
				String nextStr = it.next();
				int tmplen = nextStr.length();
				int next = Integer.parseInt(nextStr);
				for (int i = 0, j = k; i < c - '0' - 1; i++, j = single * i + k)
					leftArray[j] = next + map[tmplen] * i;
				k++;
			}
			set.clear();
			List<Integer> listLeft = Arrays.asList(leftArray);
			// middle
			set.add(String.valueOf(c));
			int cI = c - '0';
			for (int i = 1; i <= len - 1; i++) {
				double destJ = 0;
				int j = mathMap[i] * cI;
				if (i == len - 1) {
					destJ = n;
				} else {
					destJ = j + (mathMap[i]);
				}
				for (; j < destJ; j++) {
					set.add(String.valueOf(j));
				}
			}
			set.add(String.valueOf(n));
			it = set.iterator();
			while (it.hasNext()) {
				listMiddle.add(Integer.parseInt(it.next()));
			}
			listAll.addAll(listLeft);
			listAll.addAll(listMiddle);
			System.out.println(System.currentTimeMillis() - time1);
			return listAll;
		} else {

			long time01 = System.currentTimeMillis();

			Integer[] leftArray = new Integer[single * ((c - '0') - 1)];
			Integer[] rightArray = new Integer[dSingle * (9 - (c - '0'))];
			List<Integer> listMiddle = new ArrayList<Integer>();
			List<Integer> listAll = new ArrayList<Integer>();

			set.add("1");
			for (int i = 1; i <= len - 1; i++) {
				double destJ = 0;
				int j = mathMap[i];
				destJ = 2 * j;
				for (; j < destJ; j++) {
					set.add(String.valueOf(j));
				}
			}

			long time02 = System.currentTimeMillis();

			// left
			Iterator<String> it = set.iterator();
			int k = 0;
			while (it.hasNext()) {
				String nextStr = it.next();
				int tmplen = nextStr.length();
				int next = Integer.parseInt(nextStr);
				for (int i = 0, j = k; i < c - '0' - 1; i++, j = single * i + k)
					leftArray[j] = next + map[tmplen] * i;
				k++;
			}
			set.clear();
			List<Integer> listLeft = Arrays.asList(leftArray);
			long time03 = System.currentTimeMillis();
			// middle
			set.add(String.valueOf(c));
			int cI = c - '0';
			for (int i = 1; i <= len - 1; i++) {
				double destJ = 0;
				int j = mathMap[i] * cI;
				if (i == len - 1) {
					destJ = n;
				} else {
					destJ = j + (mathMap[i]);
				}
				for (; j < destJ; j++) {
					set.add(String.valueOf(j));
				}
			}
			set.add(String.valueOf(n));
			it = set.iterator();
			while (it.hasNext()) {
				listMiddle.add(Integer.parseInt(it.next()));
			}
			listAll.addAll(listLeft);
			listAll.addAll(listMiddle);
			set.clear();
			long time04 = System.currentTimeMillis();
			// right
			set.add(String.valueOf(cI + 1));
			for (int i = 1; i <= len - 2; i++) {
				double destJ = 0;
				int j = mathMap[i] * (cI + 1);
				destJ = j + (mathMap[i]);
				for (; j < destJ; j++) {
					set.add(String.valueOf(j));
				}
			}
			it = set.iterator();
			k = 0;
			while (it.hasNext()) {
				String nextStr = it.next();
				int tmplen = nextStr.length();
				int next = Integer.parseInt(nextStr);
				for (int i = 0, j = k; i < 9 - (c - '0'); i++, j = dSingle * i + k)
					rightArray[j] = next + map[tmplen] * i;
				k++;
			}
			set.clear();
			List<Integer> listRight = Arrays.asList(rightArray);
			listAll.addAll(listRight);
			long time05 = System.currentTimeMillis();
			System.out.println("total time:" + (System.currentTimeMillis() - time1));
			System.out.println("before: " + (time02 - time01));
			System.out.println("left: " + (time03 - time02));
			System.out.println("middle: " + (time04 - time03));
			System.out.println("right: " + (time05 - time04));

			return listAll;
		}
	}
}
