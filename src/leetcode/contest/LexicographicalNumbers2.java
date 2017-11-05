package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import tools.P;

public class LexicographicalNumbers2 {

	public static void main(String[] args) {
		int n = 888888;
		List<Integer> list = new LexicographicalNumbers2().lexicalOrder(n);
		// P.lnrint(list);
		// P.lnrint(list.size());

	}

	public List<Integer> lexicalOrder(int n) {
		long time1 = System.currentTimeMillis();

		if (n < 10) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				list.add(i + 1);
			return list;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mathMap = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 10);
		map.put(3, 100);
		map.put(4, 1000);
		map.put(5, 10000);
		map.put(6, 100000);
		map.put(7, 1000000);
		
		mathMap.put(1, 10);
		mathMap.put(2, 100);
		mathMap.put(3, 1000);
		mathMap.put(4, 10000);
		mathMap.put(5, 100000);
		mathMap.put(6, 1000000);
		mathMap.put(7, 10000000);
		
		
		

		String s = String.valueOf(n);
		int len = s.length();
		char c = s.charAt(0);
		int single = (int) ((Math.pow(10, len) - 1) / 9);
		int dSingle = (int) ((Math.pow(10, len - 1) - 1) / 9);

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
				long j = (long) Math.pow(10, i);
				if (i == len - 1) {
					destJ = n;
				} else {
					destJ = j + Math.pow(10, i);
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
				long j = (long) Math.pow(10, i) * (cI + 1);
				destJ = j + Math.pow(10, i);
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
					rightArray[j] = next + map.get(tmplen) * i;
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
				long j = (long) Math.pow(10, i);
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
					leftArray[j] = next + map.get(tmplen) * i;
				k++;
			}
			set.clear();
			List<Integer> listLeft = Arrays.asList(leftArray);
			// middle
			set.add(String.valueOf(c));
			int cI = c - '0';
			for (int i = 1; i <= len - 1; i++) {
				double destJ = 0;
				long j = (long) (Math.pow(10, i) * cI);
				if (i == len - 1) {
					destJ = n;
				} else {
					destJ = j + Math.pow(10, i);
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
			Integer[] leftArray = new Integer[single * ((c - '0') - 1)];
			Integer[] rightArray = new Integer[dSingle * (9 - (c - '0'))];
			List<Integer> listMiddle = new ArrayList<Integer>();
			List<Integer> listAll = new ArrayList<Integer>();

			set.add("1");
			for (int i = 1; i <= len - 1; i++) {
				double destJ = 0;
				long j = (long) Math.pow(10, i);
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
					leftArray[j] = next + map.get(tmplen) * i;
				k++;
			}
			set.clear();
			List<Integer> listLeft = Arrays.asList(leftArray);
			// middle
			set.add(String.valueOf(c));
			int cI = c - '0';
			for (int i = 1; i <= len - 1; i++) {
				double destJ = 0;
				long j = (long) (Math.pow(10, i) * cI);
				if (i == len - 1) {
					destJ = n;
				} else {
					destJ = j + Math.pow(10, i);
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
			// right
			set.add(String.valueOf(cI + 1));
			for (int i = 1; i <= len - 2; i++) {
				double destJ = 0;
				long j = (long) Math.pow(10, i) * (cI + 1);
				destJ = j + Math.pow(10, i);
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
					rightArray[j] = next + map.get(tmplen) * i;
				k++;
			}
			set.clear();
			List<Integer> listRight = Arrays.asList(rightArray);
			listAll.addAll(listRight);
			System.out.println(System.currentTimeMillis() - time1);
			return listAll;
		}
	}
}
