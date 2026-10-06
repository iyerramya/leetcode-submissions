class Solution {
    private static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(word, board, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false; 
    }

    private boolean dfs(String word, char[][] board, int i, int j, int c, boolean[][] visited) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) {
            return false;
        }
        if(c == word.length()) {
            return true;
        }
        if(visited[i][j] == true) {
            return false;
        }
        if(board[i][j] != word.charAt(c)) {
            return false;
        }

        visited[i][j] = true;

        for(int[] dir: dirs) {
            if(dfs(word, board, i+dir[0], j+dir[1], c+1, visited)) {
                visited[i][j] = false;
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}