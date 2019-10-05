class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banList = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        String res = " ";
        int count = 0;
        for (String s: banned) {
            banList.add(s);
        }
        
        // String[] splitted = paragraph.split(" ");
        String [] splitted = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        
        for (String s: splitted) {
            // String temp = s.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
            String temp = s;
            if(!banList.contains(temp)) {
                System.out.println(temp);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                // System.out.println(map.get(temp));
                if (map.get(temp) > count) {
                    count = map.get(temp);
                    res = temp;
                }
            }
        }
        
        return res;
    }
}