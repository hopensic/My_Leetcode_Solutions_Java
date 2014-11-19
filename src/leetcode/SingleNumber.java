package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int singleNumber(int[] A) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i : A) {
			map.put(i, map.get(i) == null ? true : false);
		}
		Iterator<Map.Entry<Integer, Boolean>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Boolean> entry = it.next();
			if (entry.getValue())
				return entry.getKey().intValue();
		}
		return 0;
	}

}
