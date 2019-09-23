import java.util.*;

class SurroundedRegions {
    class UnionFind {
        int count;
        private int[] rank;
        private int[] id;

        public UnionFind(int n) {
            System.out.println("n: " + n);
            rank = new int[n];
            id = new int[n];
            count = n;
            for (int i=0; i<n; i++) {
                rank[i] = 0;
                id[i] = i;
            }
        }

        public void union (int i, int j) {
            // System.out.println("i.."+ i);
            // System.out.println("j.."+ j);
            int x = find(i);
            int y = find(j);
            if (x == y) return;
            if (rank[x] < rank[y]) {
                id[x] = y; 
            } else if (rank[x] > rank[y]) {
                id[y] = x;
            } else {
                id[y] = x;
                rank[x] ++;
            }

            count -- ;
        }

        public int find (int i) {
            // System.out.println("find.. " + i);
            if (id[i] != i) {
                id[i] = find(id[i]);
            }

            return id[i];
        }

        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        if (m==0) return;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m*n + 1);
        for (int i=0; i<m ; i++) {
            for (int j=0; j<n ;j++) {
                if((i==0 || i==m-1 || j==0 || j== n-1) && board[i][j] == 'O') {
                    uf.union(i*n+j, m*n);
                }  else if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') {
                       
                        uf.union(i*n+j,(i-1)*n+j);
                    }
                    if (board[i+1][j] == 'O') {
                   
                        uf.union(i*n+j,(i+1)*n+j);
                    }
                    if (board[i][j-1] == 'O') {
              
                        uf.union(i*n+j,i*n+j-1);
                    }
                    if (board[i][j+1] == 'O') {
       
                        uf.union(i*n+j,i*n+j+1);
                    }
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n ;j++) {
                if (!uf.connected(i*n+j,n*m)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}