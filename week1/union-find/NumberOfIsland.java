import java.util.*;

class NumberOfIsland {
    class UnionFind {
        int[] parent;
        int m, n;
        int count = 0;
        public UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            parent = new int[m*n];
            for (int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        parent[id] = id;
                        count ++;
                    }
                }
            }
        }
        
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            
            return parent[i];
        }
        
        public void union(int i, int j) {
            int p1 = find(i);
            int p2 = find(j);
            
            if (p1 != p2) {
                parent[p1] = p2;
                count--;
            }
        }
        
        
    }

    public int numIslands(char[][] grid) {
        int[][] distance = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        if (grid == null || grid.length ==0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i=0 ; i<n;i++) {
            for (int j=0; j<m; j++ ) {
                if (grid[i][j] == '1') {
                    for(int[] g: distance) {
                        int x = i+g[0];
                        int y = j+g[1];
                        if (x >=0 && x<n && y>=0 && y<m && grid[x][y] == '1') {
                            uf.union(i*m+j, x*m+y);
                        } 
                    }
                }
            }
         }
        return uf.count;
    }
}