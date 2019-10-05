import java.util.*;

class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char c: J.toCharArray()) {
            set.add(c);
        }
        
        for (int i=0; i<S.length(); i++) {
            if(set.contains(S.charAt(i))) res ++;
        }
        
        return res;
    }
}