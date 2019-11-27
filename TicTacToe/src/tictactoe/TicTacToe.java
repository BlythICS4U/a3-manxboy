package tictactoe;

public class TicTacToe {
    
    private char[][] board;

    // Constructors
    public TicTacToe() {
        board = new char[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }

    // Accessor Methods
    public boolean isWinner(char p) {
        // I NEED A REAL IMPLEMENTATION!!!!!!
        return false;
    }

    public boolean isFull() {
        // I NEED A REAL IMPLEMENTATION!!!!!!
        return false;
    }

    public boolean isCat() {
        // I NEED A REAL IMPLEMENTATION!!!!!!
        return false;
    }

    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2) {
            return true;
        } else {
            return false;
        }
    }

    public char playerAt(int r, int c) {
        if (isValid(r, c)) {
            return board[r][c];
        } else {
            return '@';
        }
    }

    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    public void playMove(char p, int r, int c) {
        // I NEED A REAL IMPLEMENTATION!!!!!!
    }

}
