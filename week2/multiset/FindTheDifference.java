import java.util.*;

class FindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) -1);
        }
        
        for (Map.Entry e: map.entrySet()) {
            System.out.println(e.getValue());
            if ((int)e.getValue() < 0){
                return (char) e.getKey();
            }
        }
        
        if (map.size() == 1) {
            for (Map.Entry e: map.entrySet()) {
                return (char) e.getKey();
            }
        }
        return 'x';
    }
}