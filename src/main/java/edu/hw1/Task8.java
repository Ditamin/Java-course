package edu.hw1;

public class Task8 {
    final int size = 8;
    final int[][] moves = {{-1, 2}, {1, 2}, {2, -1}, {2, 1}};

    private boolean onBoard(int x, int y) {
        return (x >= 0) && (x < size) && (y >= 0) && (y < size);
    }

    public boolean knightBoardCapture(int[][] board) {
        for (int x1 = 0; x1 < size; ++x1) {
            for (int y1 = 0; y1 < size; ++y1) {
                if (board[x1][y1] == 1) {
                    for (var move : moves) {
                        int x2 = x1 + move[0];
                        int y2 = y1 + move[1];

                        if (onBoard(x2, y2) && (board[x2][y2] == 1)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
