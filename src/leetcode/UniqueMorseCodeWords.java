package leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
  private String arr[] = {
    ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
    "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
  };

  public static void main(String[] args) {
    String[] s = {"gin", "zen", "gig", "msg"};
    System.out.println(new UniqueMorseCodeWords().uniqueMorseRepresentations(s));
  }

  public int uniqueMorseRepresentations(String[] words) {
    Set<String> set = new HashSet<String>();
    for (String str : words) {
      StringBuffer sb = new StringBuffer();
      int len = str.length();
      for (int i = 0; i < len; i++) {
        sb.append(arr[str.charAt(i) - 'a']);
      }
      set.add(sb.toString());
    }
    return set.size();
  }
}
