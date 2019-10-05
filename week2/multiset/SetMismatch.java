import java.util.*;

class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int temp[] = new int[nums.length + 1];
        for (int i:nums) {
            temp[i] +=1;
        }
        int res[] = new int[2];
        
        for (int i=1; i< temp.length; i++) {
            // System.out.println(temp[i]);
            if (temp[i] > 1) res[0] = i;
            if (temp[i] == 0) res[1] = i;
        }
        
        
        return res;
    }
}