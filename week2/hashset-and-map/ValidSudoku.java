import java.util.*;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i=0;i<m; i++) {
            for (int j=0; j<n; j++) {
                char val = board[i][j];
                if (val !='.' ) {
                    int block = (i/3 * 3) + (j/3);
                    if (seen.contains("r"+i+val) || seen.contains("c"+j+val) || seen.contains("b"+block+val)) {
                        return false;
                    } else {
                        seen.add("r"+i+val);
                        seen.add("c"+j+val);
                        seen.add("b"+block+val);
                    }
                }
            }
        }
        return true;
    }
}