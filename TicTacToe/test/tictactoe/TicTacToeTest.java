package tictactoe;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {

    @Test
    public void testIsWinner() {
        
        //empty
        
        TicTacToe testBoard = new TicTacToe(new char[][] {
            {E, E, E},
            {E, E, E},
            {E, E, E}
        });
        
        assertEquals(testBoard.isWinner(TicTacToe.X), false);
        assertEquals(testBoard.isWinner(TicTacToe.O), false);
        
        //Vertical Line
        
        testBoard = new TicTacToe(new char[][] {
            {X, O, E},
            {E, O, E},
            {E, O, X}
        });
        
        assertEquals(testBoard.isWinner(TicTacToe.X), false);
        assertEquals(testBoard.isWinner(TicTacToe.O), true);
        
        //Horizontal Line
        
        testBoard = new TicTacToe(new char[][] {
            {E, O, E},
            {X, X, X},
            {E, O, O}
        });
        
        assertEquals(testBoard.isWinner(TicTacToe.X), true);
        assertEquals(testBoard.isWinner(TicTacToe.O), false);
        
        //diagonal line
        
        testBoard = new TicTacToe(new char[][] {
            {E, E, X},
            {O, X, X},
            {X, O, O}
        });
        
        assertEquals(testBoard.isWinner(TicTacToe.X), true);
        assertEquals(testBoard.isWinner(TicTacToe.O), false);
        
        //tie
        
        testBoard = new TicTacToe(new char[][] {
            {X, O, X},
            {O, X, O},
            {O, X, O}
        });
        
        assertEquals(testBoard.isWinner(TicTacToe.X), false);
        assertEquals(testBoard.isWinner(TicTacToe.O), false);
    }

    @Test
    public void testIsFull() {
        
        TicTacToe testBoard = new TicTacToe(new char[][] {
            {X, O, X},
            {O, O, X},
            {X, X, E}
        });
        
        assertEquals(testBoard.isFull(), false);
        
        testBoard = new TicTacToe(new char[][] {
            {E, E, E},
            {E, E, E},
            {E, E, E}
        });
        
        assertEquals(testBoard.isFull(), false);
        
        testBoard = new TicTacToe(new char[][] {
            {X, X, X},
            {O, O, X},
            {X, X, O}
        });
        
        assertEquals(testBoard.isFull(), true);
    }

    @Test
    public void testIsCat() {
        
        TicTacToe testBoard = new TicTacToe(new char[][] {
            {X, O, X},
            {O, O, X},
            {X, X, E}
        });
        
        assertEquals(testBoard.isCat(), false);
        
        testBoard = new TicTacToe(new char[][] {
            {X, O, X},
            {O, O, X},
            {X, X, E}
        });
        
        assertEquals(testBoard.isCat(), false);
    }

    @Test
    public void testIsValid() {
        
        TicTacToe testBoard = new TicTacToe(new char[][] {
            {X, O, E},
            {O, E, X},
            {X, X, E}
        });
                        
        assertEquals(testBoard.isValid(2, 2), true);
        
        assertEquals(testBoard.isValid(0, 1), true);
        
        assertEquals(testBoard.isValid(3, 2), false); 
        
    }

    @Test
    public void testPlayerAt() {
        TicTacToe testBoard = new TicTacToe(new char[][] {
            {X, O, E},
            {O, E, X},
            {X, X, E}
        });
        
        assertEquals(testBoard.playerAt(0, 0), X);
        assertEquals(testBoard.playerAt(2, 1), X);
        assertEquals(testBoard.playerAt(0, 1), O);
        
        
    }

    @Test
    public void testPlayMove() {
        TicTacToe testBoard = new TicTacToe(new char[][] {
            {E, E, E},
            {E, E, E},
            {E, E, E}
        });
        
        testBoard.playMove(X, 0, 0);
        
        assertEquals(testBoard.playerAt(0, 0), X);
        
        testBoard.playMove(O, 1, 1);
        
        assertEquals(testBoard.playerAt(1, 1), O);
        
        testBoard.playMove(X, 2, 2);
        
        assertEquals(testBoard.playerAt(2, 2), X);

    }
    
    
    //copy static piece values from the tic tac toe class
    private static final char X = TicTacToe.X;
    private static final char O = TicTacToe.O;
    private static final char E = TicTacToe.EMPTY;
}
