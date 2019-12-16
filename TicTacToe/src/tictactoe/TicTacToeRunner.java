package tictactoe;

import java.util.Scanner;
import tictactoe.TicTacToeAI.Move;

public class TicTacToeRunner {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char p = 'X';
        TicTacToe ttt = new TicTacToe();
        TicTacToeAI ai = new TicTacToeAI();
        
        int r, c;

        while (!(ttt.isWinner('X') || ttt.isWinner('O') || ttt.isFull())) {
            
            
            
            if (p == 'O') {
                
                ttt.displayBoard();
                
                System.out.print("'" + p + "', choose your location (i.e. 0 0): ");
                
                r = keyboard.nextInt();
                c = keyboard.nextInt();
                
                while (ttt.isValid(r, c) == false || ttt.playerAt(r, c) != ' ') {
                    if (ttt.isValid(r, c) == false) {
                        System.out.println("That is not a valid location. Try again.");
                    } else if (ttt.playerAt(r, c) != ' ') {
                        System.out.println("That location is already full. Try again.");
                    }

                    System.out.print("Choose your location (row, column): ");
                    r = keyboard.nextInt();
                    c = keyboard.nextInt();
                }
                
                ai.humanPlay(r, c);
                
            } else { //player equals 'X'
                
                Move move = ai.chooseSquare();
                                
                r = move.row;
                c = move.column;
            }
            
            

            

            ttt.playMove(p, r, c);

            if (p == 'X') {
                p = 'O';
            } else {
                p = 'X';
            }

        }

        ttt.displayBoard();

        if (ttt.isWinner('X')) {
            System.out.println("X is the winner!");
        }
        if (ttt.isWinner('O')) {
            System.out.println("O is the winner!");
        }
        if (ttt.isCat()) {
            System.out.println("The game is a tie.");
        }

    }
}
