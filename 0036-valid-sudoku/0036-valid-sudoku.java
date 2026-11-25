class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> col = new ArrayList<>();
        List<Set<Character>> box = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            col.add(new HashSet<>());
            box.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    }
                    row.add(board[i][j]);

                    if (col.get(j).contains(board[i][j])) {
                        return false;
                    }
                    col.get(j).add(board[i][j]);

                    int b = (i / 3) * 3 + j / 3;
                    if(box.get(b).contains(board[i][j])) {
                        return false;
                    }
                    box.get(b).add(board[i][j]);
                }
            }
        }
        return true;
    }
}