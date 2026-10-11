class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                Integer tsp1 = new Integer(log1[0]);
                Integer tsp2 = new Integer(log2[0]);
                return tsp1.compareTo(tsp2);
            }
        });
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<logs.length; i++) {
            uf.createUnion(logs[i][0], logs[i][1], logs[i][2]);
        }
        int p =  uf.find(uf.parent[0]);
        for(int i=1; i<uf.parent.length; i++) {
            if(uf.find(i) != p) {
                return -1;
            }
        }
        return uf.earliesAcq[p];
    }
}

class UnionFind {
    int[] rank;
    int[] parent;
    int[] earliesAcq;

    public UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];
        earliesAcq = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void createUnion(int ts, int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) {
            return;
        }
        int p;
        if(rank[rootX] > rank[rootY]) {
            p = x;
            parent[rootY] = rootX;
        } else if(rank[rootY] > rank[rootX]) {
            p = y;
            parent[rootX] = rootY;
        } else {
            p = x;
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        updateTime(ts, p);
    }

    public void updateTime(int ts, int x) {
        for(int i=0; i<parent.length; i++) {
            if(find(parent[i]) == find(x)) {
                earliesAcq[i] = ts;
            }
        }
    }
}