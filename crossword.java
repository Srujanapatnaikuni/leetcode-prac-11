class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (check(board, word, i, j, 0, 1) ||
                    check(board, word, i, j, 0, -1) ||
                    check(board, word, i, j, 1, 0) ||
                    check(board, word, i, j, -1, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, String word, int r, int c, int dr, int dc) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();

        int beforeR = r - dr;
        int beforeC = c - dc;

        if (beforeR >= 0 && beforeR < m && beforeC >= 0 && beforeC < n &&
            board[beforeR][beforeC] != '#') {
            return false;
        }

        int endR = r + dr * (len - 1);
        int endC = c + dc * (len - 1);

        if (endR < 0 || endR >= m || endC < 0 || endC >= n) {
            return false;
        }

        int afterR = endR + dr;
        int afterC = endC + dc;

        if (afterR >= 0 && afterR < m && afterC >= 0 && afterC < n &&
            board[afterR][afterC] != '#') {
            return false;
        }

        for (int k = 0; k < len; k++) {
            int nr = r + dr * k;
            int nc = c + dc * k;

            if (board[nr][nc] == '#') {
                return false;
            }

            if (board[nr][nc] != ' ' && board[nr][nc] != word.charAt(k)) {
                return false;
            }
        }

        return true;
    }
}