import java.util.*;

class ValidAnagram {
  public boolean isAnagram(String s, String t) {
       Map<Character, Integer> map = new HashMap<>();

       for (char c: s.toCharArray()) {
           map.put(c, map.getOrDefault(c, 0) + 1);
       }

       for (char c: t.toCharArray()) {
           if (!map.containsKey(c)) return false;
           map.put(c, map.get(c) - 1);
       }

       for (int i: map.values()) {
           if (i !=0) return false;
       }

       return true;
   }
}
