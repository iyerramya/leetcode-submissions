class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            if(dfs(a,b,map, new HashSet<>())) {
                res[0] = a;
                res[1] = b;
                return res;
            }
            if(!map.containsKey(a)) {
                map.put(a, new HashSet<>());  
            }
            map.get(a).add(b); 

            if(!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }
            map.get(b).add(a);
        }
        return res;
    }

    private boolean dfs(int a, int b, Map<Integer, Set<Integer>> map, Set<Integer> visited) {
        if(a == b) {
            return true;
        }
        if (!map.containsKey(a) || visited.contains(a)) return false;

        visited.add(a);

        for(int element:map.get(a)) {
            if(dfs(element, b, map, visited)) {
                return true;
            }
        }
        return false;
    }


}