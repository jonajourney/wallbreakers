class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        
        int len = formula.length();
        int i = 0;
        
        while (i<len) {
            char c = formula.charAt(i);
            i++;
            if (c == '(') {
                stack.push(map);
                map = new HashMap<>();
            } else if (c == ')') {
                int val = 0;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i) - '0';
                    i++;
                }
                if (val == 0) val = 1;
                
                Map<String, Integer> temp = map;
                if (!stack.isEmpty()) {
                    map = stack.pop();
                    for (String key: temp.keySet()) {
                        map.put(key, map.getOrDefault(key, 0) + temp.get(key) * val);
                    }
                }
            } else {
                int start = i-1;
                while (i< len && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String s = formula.substring(start, i);
                int val = 0;
                while(i <len && Character.isDigit(formula.charAt(i))) {
                    val = val* 10 + formula.charAt(i) - '0';
                    i++;
                }
                if (val == 0) val = 1;
                map.put(s, map.getOrDefault(s, 0) + val);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String s: list) {
            sb.append(s);
            if (map.get(s) > 1) sb.append(map.get(s));
        }
        
        return sb.toString();
    }
}