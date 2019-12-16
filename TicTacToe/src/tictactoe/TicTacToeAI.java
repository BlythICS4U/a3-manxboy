/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author manxboy
 */
public class TicTacToeAI {
    
    /**
     * Tic Tac Toe Board
     * 
     * statically initialized to be empty
     */
    public char[][] board = {
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY}
    };
    
    /**
     * Input the humans move
     * @param r the row
     * @param c the column
     */
    public void humanPlay(int r, int c) {
        board[r][c] = HUMAN;
    }
    
    /**
     * Get the next move from the AI
     * @return the Move made
     */
    public Move chooseSquare() {
        int row = 0;
        int column = 0;
        
        //check wether the chosen place is empty
        while (board[row][column] != EMPTY) {
            //if not, randomly choose new spot
            
            //get a random number in the range [0 1), then scale it to be an integer of either 0, 1, or 2
            row = (int) Math.round(Math.random() * 2);
            column = (int) Math.round(Math.random() * 2);
        }
        
        //set the ai's view to reflect the changes
        this.board[row][column] = AI;
        
        //return the move
        return new Move(row, column);
    }
    
    /**
     * Represents a move by the ai
     * Wraps the row and column values
     */
    public class Move {
        /**The row*/
        public final int row;
        /**The Column*/
        public final int column;
        
        /**
         * Represents a move made by the ai
         * @param r the row
         * @param c the column
         */
        public Move(int r, int c) {
            this.row = r;
            this.column = c;
        }
        
        /**
         * get the row
         * @return the index of the row
         */
        public int getRow() {
            return row;
        }
        
        /**
         * get the column
         * @return the index of the column
         */
        public int getColumn() {
            return column;
        }
    }
    
    public static final char HUMAN = 'X';
    public static final char AI    = 'O';
    public static final char EMPTY = ' ';
}
