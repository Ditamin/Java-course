package edu.hw1;

public class Task8 {
    final int size = 8;
    final int[][] moves = {{-1, 2}, {1, 2}, {2, -1}, {2, 1}};

    private boolean onBoard(int x, int y) {
        return (x >= 0) && (x < size) && (y >= 0) && (y < size);
    }

    public boolean knightBoardCapture(int[][] board) {
        for (int x = 0; x < size; ++x) {
            for (int y = 0; y < size; ++y) {
                if (board[x][y] == 1) {
                    for (var move : moves) {
                        if (onBoard(x + move[0], y + move[1]) && (board[x + move[0]][y + move[1]] == 1)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
