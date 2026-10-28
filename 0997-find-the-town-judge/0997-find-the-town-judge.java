class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> indegree = new HashMap<>();
        Map<Integer, List<Integer>> outdegree = new HashMap<>();

        for(int i=1; i<=n; i++) {
            outdegree.put(i, new ArrayList<>());
            indegree.put(i, new ArrayList<>());
        }

        for(int[] t : trust) {
            outdegree.get(t[0]).add(t[1]);
            indegree.get(t[1]).add(t[0]);
        }

        List<Integer> maybeJudges = new ArrayList<>();

        for(int entry : outdegree.keySet()) {
            if(outdegree.get(entry).isEmpty()) {
                maybeJudges.add(entry);
            }
        }
        if(maybeJudges.isEmpty()) {
            return -1;
        }
        for(int maybeJudge : maybeJudges) {
            if(indegree.get(maybeJudge).size() == n-1) {
                return maybeJudge;
            }
        }
        return -1;
        
    }
}