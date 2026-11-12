class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rooms[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int[] dir: dirs) {
                int newX = x+dir[0];
                int newY = y+dir[1];
                if(newX>= 0 && newX<m && newY>=0 && newY<n && rooms[newX][newY] == Integer.MAX_VALUE) {
                    rooms[newX][newY] = rooms[x][y]+1; 
                    q.offer(new int[]{newX, newY});
                }
            }
        }
        
    }
}