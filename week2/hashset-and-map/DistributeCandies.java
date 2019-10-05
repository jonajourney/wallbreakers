import java.util.*;

class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        
        for (int i: candies) {
            set.add(i);
        }
        
        int halved = candies.length / 2;
        if (set.size() > halved) {
            return halved;
        }
        return set.size();
    }
}