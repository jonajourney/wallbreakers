import java.util.*;

class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String s: cpdomains) {
            String[] firstSplit = s.split(" ");
            String[] secondSplit = firstSplit[1].split("\\.");
            // System.out.println(firstSplit[0]);
            String temp="";
            boolean first = true;
            int count = Integer.parseInt(firstSplit[0]);
            for (int i=secondSplit.length - 1; i>=0; i--) {
                if (!first) { 
                    temp ="." + temp;
                } else {
                    first = false;
                }
                temp = secondSplit[i] + temp;
                map.put(temp, map.getOrDefault(temp, 0) + count);
            }
        }
        for (Map.Entry e: map.entrySet()) {
            
            String ans = "";
            ans += Integer.toString((int)e.getValue());
            ans +=" ";
            ans+= e.getKey();
            res.add(ans);
        }

        return res;
    }
}