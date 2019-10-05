import java.util.*;

class IsHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (set.add(n)) {
            int temp = 0;
            while (n>0) {
                int digit = n%10;
                temp += (digit * digit);
                n /= 10;
            }
            
            if (temp == 1) return true;
            else n = temp;
        }
        
        return false;
    } 
}