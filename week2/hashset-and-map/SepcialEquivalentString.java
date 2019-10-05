import java.util.*;

class SpecialEquivalentString {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s: A) {
            set.add(helper(s));
        }
        
        return set.size();
    }
    
    public String helper(String s1) {
        // char[] odd = new int[s1.length()];
        // char[] even = new int[s1.length()];
        
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        for (int i=0 ;i<s1.length(); i++) {
            if (i%2 == 1) {
                odd.append(s1.charAt(i));
            } else {
                even.append(s1.charAt(i));
            }
        }
        char []temp1 = odd.toString().toCharArray();
        Arrays.sort(temp1);
        char []temp2 = even.toString().toCharArray();
        Arrays.sort(temp2);
        
        return new String(temp1) + new String(temp2);
    }
}