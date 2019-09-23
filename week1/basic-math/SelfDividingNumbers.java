import java.util.*;

class SelfDividingNumbers {
  public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i<=right; i++) {
            if (helper(i)) {
                res.add(i);
            }
        }

        return res;
    }

    public boolean helper(int input) {
        int inputTemp = input;
        while(inputTemp != 0) {
            int temp = inputTemp % 10;
            if (temp == 0) return false;
            if (input % temp != 0) return false;
            inputTemp /= 10;
        }

        return true;
    }
}
