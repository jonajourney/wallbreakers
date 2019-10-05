class AllAnagramInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        
        if (p.length()>s.length()) return res;
        Map<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        
        int counter = map.size();
        int begin = 0, end = 0;
        int head = 0;
        
        while(end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter -- ;
            }
            end ++;
            
            while(counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if(end - begin == p.length()) {
                    res.add(begin);
                }
                begin++;
            }
        }
        return res;
        
    }
    // TLE
    // public List<Integer> findAnagrams(String s, String p) {
    //     List<Integer> res = new ArrayList<>();
    //     for (int i=0; i<s.length() -p.length() + 1; i++) {
    //         String temp = s.substring(i, i+ p.length());
    //         // System.out.println(temp);
    //         if (isMatch(temp, p) && isMatch(p, temp)) {
    //             res.add(i);
    //         }
    //     }
        
    //     return res;
    // }
    
    //  public boolean isMatch(String x, String y) {
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char c: y.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) + 1);
    //     }
         
    //      for (char c: x.toCharArray()) {
    //         map.put(c, map.getOrDefault(c, 0) - 1);
    //     }
         
    //      for (int i: map.values()) {
    //          if (i !=0) return false;
    //      }
    //      return true;
    // }
}