package tictactoe;

public class TicTacToe {
    
    private char[][] board;

    /**
     * Default Constructor
     * Creates two-dimensional array and fills each slot with ' '
     */
    public TicTacToe() {
        board = new char[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }
    
    /**
     * Custom constructor that allows you to set the contents of the board
     * @param board the board to use
     */
    public TicTacToe(char[][] board) {
        this.board = board;
    }

    // Accessor Methods
    
    /**
     * Checks if the specified player has won
     * @param p the player to check
     * @return true if win-condition in favor of player, else false
     */
    public boolean isWinner(char p) {
        
        boolean winner = false;
        
        for (int i = 0; i < 3; i++) {
            //check horizontal line for win by checking each cell in the row is equal to the player
            winner |= (board[i][0] == p) && (board[i][1] == p) && (board[i][2] == p);
            
            
            //check the vertical line for a win:
            
            //store the current state of the line
            boolean vertical = true;
            
            
            for (int j = 0; j < 3; j++) {
                //and the state of the line with wether the cell is equal the the player
                //effectively setting vertical to false if any of the cells are not equal to the player
                vertical &= board[j][i] == p;
            }
            
            winner |= vertical;
        }
        
        //check the diangonals :
        
        //top left to bottom right
        winner |= (board[0][0] == p) && (board[1][1] == p) && (board[2][2] == p);
        //top right to bottom left
        winner |= (board[0][2] == p) && (board[1][1] == p) && (board[2][0] == p);
        
        return winner;
    }

    /**
     * Checks if the board is full (every square in the 9x9 has either a 'X' or
     * and 'O')
     * @return true if the board is full, else false
     */
    public boolean isFull() {
        
        //ittorate over every row
        for (char[] rows : board) {
            
            //ittorate over every cell in each row
            for (char cell : rows) {
                
                //if the cell is empty, return false
                if (cell == EMPTY) return false;
            }
        }
        
        //if we get here then there are no empty cells
        return true;
    }

    /**
     * Checks if the game is tied (every square is full and there is no win
     * condition)
     * @return true if the game is tied, else false
     */
    public boolean isCat() {
        //returns true if the board is full and no player has won
        return isFull() && !(isWinner(O) || isWinner(X));
    }

    /**
     * Checks if the given row and column corresponds to a valid space on the
     * board (i.e. the space is in range)
     * @param r the row
     * @param c the column
     * @return true if the space is valid, else false
     */
    public boolean isValid(int r, int c) {
        if (0 <= r && r <= 2 && 0 <= c && c <= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the piece at a give row and column
     * @param r the row
     * @param c the column
     * @return ' ' for no piece, 'X' for x players piece, 'O' for o players
     * piece
     */
    public char playerAt(int r, int c) {
        if (isValid(r, c)) {
            return board[r][c];
        } else {
            return '@';
        }
    }

    /**
     * displays the current board on the screen
     */
    public void displayBoard() {
        System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("    --+-+--");
        System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("    --+-+--");
        System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("     0 1 2 ");
    }

    // Modifiers
    
    /**
     * allows the given player to place their move at the given row and column.
     * The row and column numbers are 0-based, so valid numbers are 0, 1, 2.
     * @param p the player
     * @param r the row
     * @param c the column
     */
    public void playMove(char p, int r, int c) {
        board[r][c] = p;
    }

    /**Represents the X player's piece*/
    public static final char X     = 'X';
    /**Represents the O player's piece*/
    public static final char O     = 'O';
    /**Represents no piece (empty cell)*/
    public static final char EMPTY = ' ';
}
