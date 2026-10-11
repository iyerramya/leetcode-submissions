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
        int groupCount = n;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<logs.length; i++) {
            if(uf.createUnion(logs[i][0], logs[i][1], logs[i][2])) {
                groupCount -= 1;
            }
            if(groupCount == 1) {
                return logs[i][0];
            }
        }
        return -1;
    }
}

class UnionFind {
    int[] rank;
    int[] parent;

    public UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];

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

    public boolean createUnion(int ts, int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        boolean isMerged = false;

        if(rootX == rootY) {
            return isMerged;
        }

        isMerged = true;
        if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if(rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return isMerged;
    }
}