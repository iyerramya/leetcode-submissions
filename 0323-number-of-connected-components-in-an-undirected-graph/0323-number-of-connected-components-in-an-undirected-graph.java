class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uFind = new UnionFind(n);
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<edges.length; i++) {
            uFind.createUnion(edges[i][0], edges[i][1]);
        }
        for(int i=0; i<n; i++) {
            set.add(uFind.find(i));
        }
        return set.size();
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for(int i=0; i<size; i++) {
            parent[i] = i;
        }
        rank = new int[size];
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void createUnion(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) {
            return;
        }
        if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if(rank[rootY] > rank[rootX]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        //System.out.println("x: "+x+" y:"+y);
        //printParent();
    }

    public void printParent() {
        for(int i=0;i<parent.length; i++) {
            System.out.print(parent[i]+ ", ");
        }
         System.out.println("");
    }
}