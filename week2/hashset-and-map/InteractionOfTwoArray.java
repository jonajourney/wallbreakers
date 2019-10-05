import java.util.*;

class InteractionOfTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> added = new HashSet<>();

        for (int i: nums1) {
            set.add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int i: nums2) {
            if (set.contains(i) && !added.contains(i)) {
                result.add(i);
                added.add(i);
            }
        }
        
        int [] res = new int[result.size()];
        int index = 0;
        for (int i: result) {
            res[index] = i;
            index++;
        }
        
        return res;
    }
}