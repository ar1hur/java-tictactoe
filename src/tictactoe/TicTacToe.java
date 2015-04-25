/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import tictactoe.Exceptions.MoveException;

/**
 *
 * @author arthur
 */
public class TicTacToe
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Player p1 = new Player("arthur");
        Player p2 = new Player("felix");

        Game game = new Game(p1, p2);
        game.start();

        do {
            game.printBoard();
            System.out.println(game.getCurrentPlayer().getName() + " ist am Zug.");
            boolean moved = false;

            while (!moved) {

                try {
                    System.out.print("Eingabe: ");
                    moved = game.move(buffer.readLine());
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                catch (MoveException | IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        while (game.isRunning());

        game.printBoard();
        if (game.hasWinner()) {
            System.out.println(game.getCurrentPlayer().getName() + " hat gewonnen");
        }
        else {
            System.out.println("Keiner hat gewonnen :(");
        }
    }

}
