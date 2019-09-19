import java.util.*;

class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i: A) {
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        for (int i=0; i< even.size(); i++) {
            A[i] = even.get(i);
        }

        int index = even.size();
        for (int i=0; i< odd.size(); i++) {
            A[index] = odd.get(i);
            index ++;
        }

        return A;
    }
}
