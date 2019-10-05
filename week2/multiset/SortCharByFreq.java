import java.util.*;

class SortCharByFreq {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> [] list = new List[s.length()+1];
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c: map.keySet()) {
            int index = map.get(c);
            if (list[index] == null) {
                list[index] = new ArrayList<>();
            }
            list[index].add(c);
        }
        
        StringBuilder res = new StringBuilder();
        
        for (int i=list.length - 1; i>=0; i--) {
            if (list[i] != null) {
                for (char c : list[i]) {
                    for(int count = 0; count < i; count ++) {
                     res.append(c);
                    } 
                }
                  
            }
            
        }
        return res.toString();
        
        
    }
}