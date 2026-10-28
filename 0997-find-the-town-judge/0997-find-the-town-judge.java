class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

       
        for(int[] t : trust) {
            outdegree[t[0]] += 1;
            indegree[t[1]] += 1;
        }

        for(int i=1;i<=n; i++) {
            if(outdegree[i]==0) {
                if(indegree[i]==n-1) {
                    return i;
                }
            }
        }

        return -1;
        
    }
}