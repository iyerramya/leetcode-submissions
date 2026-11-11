class Solution {
    boolean hasPath = false;
    int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dfs(start[0], start[1], maze, new int[maze.length][maze[0].length], destination);
        return hasPath;
    }

    private void dfs(int i, int j, int[][] maze, int[][] visited, int[] d) {
      
        if (i == d[0] && j == d[1]) {
            hasPath = true;
            return;
        }

        visited[i][j] = 1;

        for(int[] dir : dirs) {
            int x = i;
            int y = j;
            while(x+dir[0] >= 0 && x+dir[0] < maze.length && y+dir[1] >=0 && y+dir[1] < maze[0].length && maze[x+dir[0]][y+dir[1]] == 0) {
                x+=dir[0];
                y+=dir[1];
            }
            if(visited[x][y] == 0) {
                dfs(x,y,maze,visited,d);
            }
        }



    }


}