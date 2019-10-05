import java.util.*;

class UncommonWords {
    public String[] uncommonFromSentences(String A, String B) {
        String[] sa = A.split(" ");
        String[] sb = B.split(" ");
        Set<String> set = new HashSet<>();
        Set<String> appeared = new HashSet<>();
        
        for (String s: sa) {
            if (set.contains(s)) {
                set.remove(s);
                appeared.add(s);
            } else if(!appeared.contains(s)){
                set.add(s);
            }
        }
        
        for (String s: sb) {
            if (set.contains(s)) {
                set.remove(s);
                appeared.add(s);
            } else if (!appeared.contains(s)){
                set.add(s);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for (String s: set) {
            res.add(s);
        }
        
        String[] str = new String[set.size()];
        res.toArray(str);
        return str;
    }
}