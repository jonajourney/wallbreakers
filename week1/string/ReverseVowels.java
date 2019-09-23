import java.util.*;

class ReverseVowels {
  public String reverseVowels(String s) {
    char[] vowels = new char[s.length()];
    int index = 0;
    Set<Character> set = new HashSet<Character>(Arrays.asList('a','e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


    for (int i=0; i<s.length(); i++) {
        if (set.contains(s.charAt(i))) {
            vowels[index] = s.charAt(i);
            index++;
        }
    }
    StringBuilder sb = new StringBuilder();
    index -- ;
    for (int i=0; i<s.length(); i++) {
        if(set.contains(s.charAt(i))) {
            sb.append(vowels[index]);
            index -- ;
        } else {
            sb.append(s.charAt(i));
        }
    }
    return sb.toString();

  }
}
