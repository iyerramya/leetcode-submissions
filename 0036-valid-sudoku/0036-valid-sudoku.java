class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for(int r=0; r<N; r++) {
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(board[r][c] == '.') {
                    continue;
                }

                char num = board[r][c];

                if(rows[r].contains(num)) {
                    return false;
                }
                rows[r].add(num);

                if(cols[c].contains(num)) {
                    return false;
                }
                cols[c].add(num);

                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(num)) {
                    return false;
                }
                boxes[idx].add(num);                
            }
        }

        return true;
    }
}