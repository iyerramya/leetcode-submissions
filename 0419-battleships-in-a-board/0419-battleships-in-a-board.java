class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int numBattleShips = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'X') {
                    numBattleShips++;
                    dfs(i,j,board);
                }
            }
        }
        return numBattleShips;
    }

    private void dfs(int i, int j, char[][] board) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) {
            return;
        }
        if(board[i][j] != 'X') {
            return;
        }

        board[i][j] = 'A';
        dfs(i+1, j, board);
        dfs(i, j+1, board);
    }
}