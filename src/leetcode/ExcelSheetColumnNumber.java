package leetcode;

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println('A' - 'A' + 1);

		System.out.println(new ExcelSheetColumnNumber().titleToNumber("BA"));
	}

	public int titleToNumber(String s) {
		int len = s.length();
		char[] arr = s.toCharArray();
		int total = 0;
		for (int i = 0; i < len; i++) {
			total += (arr[i] - 'A' + 1) * Math.pow(26, len - i - 1);
		}
		return total;
	}
}
