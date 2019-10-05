import java.util.*;

class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        if (s.length() != t.length()) return false;
        
        for (int i=0; i<s.length(); i++) {
            if((map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i))||
              (m2.containsKey(t.charAt(i)) && m2.get(t.charAt(i)) != s.charAt(i) )) {
                return false;
            } 
            if (!map.containsKey(s.charAt(i)) ) {
                map.put(s.charAt(i), t.charAt(i));
            }
            if (!m2.containsKey(t.charAt(i))) {
                m2.put(t.charAt(i), s.charAt(i));
            }
        }
        
        return true;
    }
}