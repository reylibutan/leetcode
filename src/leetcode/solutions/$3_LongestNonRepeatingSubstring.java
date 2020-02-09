package leetcode.solutions;

public class $3_LongestNonRepeatingSubstring {

  public static void main(String[] args) {
    $3_BrutForceSolution s = new $3_BrutForceSolution();

    String input = "jbpnbwwd";

    System.out.println(s.lengthOfLongestSubstring(input));
  }

}


class $3_BrutForceSolution {

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    int result = 1;
    StringBuffer curr = new StringBuffer();

    char[] str = s.toCharArray();
    for (int i = 0; i < str.length - 1; i++) {
      curr = new StringBuffer(String.valueOf(str[i]));
      for (int j = i + 1; j < str.length; j++) {
        if (curr.toString().contains(String.valueOf(str[j]))) {
          if (curr.length() > result) {
            result = curr.length();
          }
          break;
        } else {
          curr.append(str[j]);
          if (j + 1 == str.length && curr.length() > result) {
            result = curr.length();
          }
        }
      }
    }

    return result;
  }

}
