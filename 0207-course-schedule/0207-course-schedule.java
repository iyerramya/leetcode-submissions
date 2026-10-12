 class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
                int[] dependency = new int[numCourses]; 
        HashMap<Integer, List> map = new HashMap<Integer, List>();
        
        for(int i=0; i<prerequisites.length; i++) {
            //dependency array
            dependency[prerequisites[i][0]]++;
            
            //mapping dependencies
            
            if(!map.containsKey(prerequisites[i][1])) { 
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);  
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<dependency.length; i++) {
            if(dependency[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int dep = q.poll();
            if(map.containsKey(dep)) {
                List<Integer> temp = map.get(dep);
                for(int i=0; i<temp.size(); i++) {
                    int val = temp.get(i);
                    if( dependency[val] > 0) {
                        dependency[val]--;
                    }
                    if(dependency[val] == 0) {
                        q.add(val);
                    }
                }    
            }
        }
        
        for(int i=0; i<dependency.length; i++) {
            if(dependency[i] > 0)
                return false;
        }
        
        return true;
    }
}