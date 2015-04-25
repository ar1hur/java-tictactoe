/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import tictactoe.Exceptions.MoveException;

/**
 *
 * @author arthur
 */
public class Game
{

    private final char[] tokens = {'X', 'O'};
    private final char[] board = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    private final Player[] players = new Player[2];
    private boolean running = false;
    private byte current = 0;
    private byte count;
    private boolean winner;

    public Game(Player player1, Player player2)
    {
        this.players[1] = player1;
        this.players[0] = player2;
    }

    public boolean isRunning()
    {
        this.check();
        return this.running;
    }

    public void start()
    {
        this.count = 0;
        this.running = true;
        this.winner = true;
    }

    public boolean hasWinner()
    {
        this.current = (byte) (this.current == 0 ? 1 : 0);
        return this.winner;
    }

    public Player getCurrentPlayer()
    {
        return this.players[this.current];
    }

    public boolean move(String input) throws MoveException
    {
        int i;

        try {
            i = input.toUpperCase().codePointAt(0) - 65;
        }
        catch (StringIndexOutOfBoundsException ex) {
            i = 100;            
        }

        if (i >= 0 && i < this.board.length) {
            if (this.board[i] != this.tokens[0] && this.board[i] != this.tokens[1]) {

                this.board[i] = this.tokens[this.current];
                this.current = (byte) (this.current == 0 ? 1 : 0);
                this.count++;

                return true;
            }
            
            throw new MoveException("sry, Zug nicht möglich.");
        }
        else {
            throw new IllegalArgumentException("ups, falsche Eingabe!");            
        }        
    }

    private void check()
    {
        if (this.count == this.board.length) {
            this.running = false;
            this.winner = false;
        }
        else {
            this.checkRows((byte) 0);
        }
    }

    private void checkRows(byte i)
    {
        if ((i + 2) > this.board.length || (i + 6) >= this.board.length) {
            return;
        }

        /*
         horizontal
         0 == 1 == 2
         3 == 4 == 5
         6 == 7 == 8
         */
        if (this.board[i] == this.board[i + 1] && this.board[i] == this.board[i + 2]) {
            this.running = false;
            return;
        }

        /*
         vertical
         0 == 3 == 6
         1 == 4 == 7       
         2 == 5 == 8
         */
        if (this.board[i] == this.board[i + 3] && this.board[i] == this.board[i + 6]) {
            this.running = false;
            return;
        }

        /*
         diagonal
         */
        if ((this.board[0] == this.board[4] && this.board[4] == this.board[8])
                || (this.board[2] == this.board[4] && this.board[4] == this.board[6])) {
            this.running = false;
            return;
        }

        i += 3;
        this.checkRows(i);
    }

    public void printBoard()
    {
        byte i;

        for (i = 0; i < this.board.length; i++) {

            System.out.print(this.board[i]);

            if ((i + 1) % 3 != 0) {
                System.out.print("|");
            }

            if (i == 2 || i == 5) {
                System.out.println("\n-----");
            }
        }
        System.out.println("\n");
    }
}
