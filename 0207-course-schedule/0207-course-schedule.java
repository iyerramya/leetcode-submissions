class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> outdegree = new HashMap<>();

        for(int[] prerequisite : prerequisites) {
            indegree[prerequisite[1]]++;
            if(!outdegree.containsKey(prerequisite[0])) {
                outdegree.put(prerequisite[0], new ArrayList<>());
            }
            outdegree.get(prerequisite[0]).add(prerequisite[1]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int completedCourses = 0;

        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                completedCourses += 1;
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> courses = outdegree.get(curr);
            if(courses!=null) {
                for(int i=0; i<courses.size(); i++) {
                    indegree[courses.get(i)] -= 1;
                    if(indegree[courses.get(i)] == 0) {
                        completedCourses += 1;
                        q.offer(courses.get(i));
                    }
                }
            }

        }

        return completedCourses == numCourses;
        
    }
}