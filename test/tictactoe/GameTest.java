/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoe.Exceptions.MoveException;

/**
 *
 * @author arthur
 */
public class GameTest
{

    private Game game;

    public GameTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
        Player p1 = new Player("arthur");
        Player p2 = new Player("felix");

        this.game = new Game(p1, p2);
    }

    @After
    public void tearDown()
    {
        this.game = null;
    }

    /**
     * Test of isRunning method, of class Game.
     */
    @Test
    public void testIsRunning()
    {
        System.out.println("isRunning");

        assertFalse(this.game.isRunning());
        this.game.start();
        assertTrue(this.game.isRunning());
    }

    /**
     * Test of hasWinner method, of class Game.
     */
    @Test
    public void testHasWinner() throws MoveException
    {
        System.out.println("hasWinner");
        
        this.game.start();

        String[] moves = {"a", "b", "c", "d", "e", "f", "h", "g", "i"};
        byte i = 0;
        do {
            this.game.move(moves[i]);
            i++;
        }
        while( game.isRunning() );
        
        assertFalse(this.game.hasWinner());
    }

    /**
     * Test of getCurrentPlayer method, of class Game.
     */
    @Test
    public void testGetCurrentPlayer() throws MoveException
    {
        System.out.println("getCurrentPlayer");
        
        this.game.start();

        String[] moves = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
        byte i = 0;
        do {
            this.game.move(moves[i]);
            i++;
        }
        while( game.isRunning() );
        
        assertTrue(this.game.hasWinner() && "felix".equals(this.game.getCurrentPlayer().getName()));
    }

    /**
     * Test of move method, of class Game.          
     */
    @Test(expected=MoveException.class)
    public void testMove() throws MoveException
    {
        System.out.println("move");
        
        this.game.start();
        
        this.game.move("d");
        this.game.move("d");
    }

    /**
     * Test of move method, of class Game.          
     */
    @Test(expected=IllegalArgumentException.class)
    public void testMoveInvalid() throws IllegalArgumentException, MoveException
    {
        System.out.println("move invalid input");
        
        this.game.start();               
        this.game.move("j");
    }
}
