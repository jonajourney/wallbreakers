import java.util.*;

class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs == null) return null;
    if (strs.length == 0) return "";
    int min = Integer.MAX_VALUE;
    for (String s: strs) {
        min = Math.min(min, s.length());
    }

    StringBuilder sb = new StringBuilder();
    int index = 0;
    char[] compare = new char[strs[0].length()];
    compare = strs[0].toCharArray();

    while (index < min) {
        char temp = compare[index];
        boolean flag = true;
        for (int i=0; i<strs.length; i++) {
            if (strs[i].charAt(index) != temp) {
                System.out.println(strs[i].charAt(index));
                flag = false;
                break;
            }

        }
        if (flag) {
            sb.append(temp);
        } else {
            break;
        }
        index ++;
    }


    return sb.toString();
  }
}
