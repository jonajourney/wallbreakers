import java.util.*;

class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] split1 = str.split(" ");
        Set<String> appeared = new HashSet<>();
        
        if (pattern.length() != split1.length) return false;
        
        for (int i=0 ; i<pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (appeared.contains(split1[i])) return false;
                map.put(pattern.charAt(i), split1[i]);
                appeared.add(split1[i]);
                
            } else if (map.containsKey(pattern.charAt(i))) {
                // System.out.println(map.get(pattern.charAt(i)).length() );
                // System.out.println(split1[i].length());
                if (!map.get(pattern.charAt(i)).equals(split1[i]) ) return false;
            }
        }
        
        return true;
    } 
}