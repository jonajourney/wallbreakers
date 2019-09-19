import java.util.*;

class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i=0; i< A.length; i++) {
            flip(A[i]);
            invert(A[i]);
        }

        return A;
    }

    public void flip(int[] A) {
        int temp[] = new int[A.length];
        int index = 0;
        for (int i=A.length - 1; i >= 0; i--) {
            temp[index] = A[i];
            index ++;
        }
        for (int i=0; i< temp.length; i++) {
            A[i] = temp[i];
        }
    }

    public void invert(int[] A) {
        for (int i=0; i< A.length; i++) {
            if (A[i] == 0) A[i] = 1;
            else if (A[i] == 1) A[i] = 0;
        }
    }
}
