class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for(int i=1; i<=n; i++) {
            outdegree.put(i, 0);
            indegree.put(i, 0);
        }

        for(int[] t : trust) {
            outdegree.put(t[0], outdegree.get(t[0])+1);
            indegree.put(t[1], indegree.get(t[1])+1);
        }

        List<Integer> maybeJudges = new ArrayList<>();

        for(int entry : outdegree.keySet()) {
            if(outdegree.get(entry)==0) {
                maybeJudges.add(entry);
            }
        }
        if(maybeJudges.isEmpty()) {
            return -1;
        }
        for(int maybeJudge : maybeJudges) {
            if(indegree.get(maybeJudge) == n-1) {
                return maybeJudge;
            }
        }
        return -1;
        
    }
}