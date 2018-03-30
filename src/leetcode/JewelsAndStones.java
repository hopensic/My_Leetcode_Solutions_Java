package leetcode;

public class JewelsAndStones {

  public static void main(String[] args) {
    String J = "aA";
    String S = "aAAbbbb";

    System.out.println(new JewelsAndStones().numJewelsInStones(J, S));
  }

  public int numJewelsInStones(String J, String S) {
    char arr[] = J.toCharArray();
    char s[] = S.toCharArray();
    int n = 0;
    for (char ch : s) for (char c : arr) if (c == ch) n++;
    return n;
  }
}
