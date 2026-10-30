class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> outdegree = new HashMap<>();

        for(int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            if(!outdegree.containsKey(prerequisite[1])) {
                outdegree.put(prerequisite[1], new ArrayList<>());
            }
            outdegree.get(prerequisite[1]).add(prerequisite[0]);
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
            res.add(curr);
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

        if (completedCourses == numCourses) {
            int[] order = new int[numCourses];
                for (int i = 0; i < numCourses; i++) {
                    order[i] = res.get(i);
                }
            return order;
        } else {
            return new int[0];
        }         
    }
}