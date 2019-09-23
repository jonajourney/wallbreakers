import java.util.*;

class PlusOne {
  public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        while(index >=0) {
            if (digits[index] < 9) {
                digits[index] += 1;
                return digits;
            }
            digits[index] = 0;
            index -- ;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;
    }
}
