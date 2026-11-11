class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int[][] dist = new int[maze.length][maze[0].length];
        dist[start[0]][start[1]] = 0;
        q.offer(new int[]{start[0], start[1], 0});
        for(int[] row:dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir:dirs) {
                int x = curr[0];
                int y = curr[1];
                int moves = 0;
                while(x+dir[0] >=0 && x+dir[0] < maze.length && y+dir[1] >=0 && y+dir[1] < maze[0].length && maze[x+dir[0]][y+dir[1]] == 0 ) {
                    x += dir[0];
                    y += dir[1];
                    moves++;
                }
                int newDistance = curr[2]+moves;
                if(newDistance < dist[x][y]) {
                    dist[x][y] = newDistance;
                    q.offer(new int[]{x,y,newDistance});
                }
            }
        }
        int d = dist[destination[0]][destination[1]];
        return d == Integer.MAX_VALUE ? -1 : d;
    }
}