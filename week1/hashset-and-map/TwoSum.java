import java.util.*;

class TwoSum {
  public int[] twoSum(int[] nums, int target) {
       int[] res = new int[2];
       Map<Integer, Integer> map = new HashMap<>();

       Set<Integer> set = new HashSet<>();

       for (int i : nums) {
           set.add(i);
       }

       for (int i=0; i< nums.length ;i++) {
           if (set.contains(target - nums[i])) {
               int temptarg = target - nums[i];
               for (int x=i+1; x<nums.length; x++) {
                   if (nums[x] == temptarg) {
                       res[0] = i;
                       res[1] = x;
                       return res;
                   }
               }
           }
       }
       return res;
   }
}
