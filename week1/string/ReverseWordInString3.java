import java.util.*;

class ReverseWordInString3 {
  public String reverseWords(String s) {
    List<String> res = new ArrayList<>();

    for (String si: s.split(" ")) {
        res.add(words(si));
    }

    StringBuilder sb = new StringBuilder();
    for (String sii: res) {
        sb.append(sii);
        sb.append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);

    return sb.toString();
}

  public String words(String s) {
      int len = s.length();
      char[] tempArr = s.toCharArray();

      for (int i=0; i< len / 2; i++) {
          char temp = tempArr[i];
          tempArr[i] = tempArr[len - i -1];
          tempArr[len - i -1] = temp;
      }
      String res = new String(tempArr);

      return res;
  }
}
