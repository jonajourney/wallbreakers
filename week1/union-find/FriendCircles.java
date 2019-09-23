import java.util.*;

class FriendCircles {
  class UnionFind {
        private int count;
        private int [] rank, parent;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;

            for (int i=0; i<n;i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public void union(int i, int j) {
            int p1 = find(i);
            int p2 = find(j);

            if (p1 == p2) return;

            if (rank[p2] > rank[p1]) {
                parent[p1] = p2;
            } else {
                parent[p2] = p1;
                if (rank[p2] == rank[p1]) {
                    rank[p1] ++;
                }
            }
            count -- ;
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i=0; i<M.length; i++) {
            for (int j=0; j< M[0].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j) ;
                }

            }
        }
        return uf.count;
    }
}
