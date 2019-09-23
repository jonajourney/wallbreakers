import java.util.*;

class BinaryGap {
  public int binaryGap(int N) {
        int max = 0;
        int lastPos = -1;
        int pos = 0;

        while (N!=0) {
            pos++;
           if ((N & 1) == 1) {
                   if (lastPos != -1) {
                   max = Math.max(max, pos - lastPos);
               }
               lastPos = pos;
           }
            N >>= 1;
        }

        return max;
    }
}
