import java.util.*;

class UniqueMorseCode {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        
        String [] alphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}; 
        int index = 97;
        for (String s: alphabet) {
            map.put((char)index, s);
            index++;
        }
        for (int i=0; i<words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c: words[i].toCharArray()) {
                sb.append(map.get(c));
            }
            set.add(sb.toString());
        }
        
        return set.size();
        
    }
}