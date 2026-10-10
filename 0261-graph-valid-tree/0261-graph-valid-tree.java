class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        UnionFind uFind = new UnionFind(n);
        for(int i=0; i<edges.length; i++) {
            if(!uFind.unionSet(edges[i][0], edges[i][1])) {
                return false;
            }
        }

        return true;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for(int i = 0; i<size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while(parent[x] != x) {
           x = find(parent[x]);
        }
        return x;
    }

    public boolean unionSet(int x, int y) {
        int xset = find(x);
        int yset = find(y);
        if(xset == yset) {
            return false;
        }
        parent[yset] = xset;
        return true;
    }
}
