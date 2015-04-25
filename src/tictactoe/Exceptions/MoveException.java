/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.Exceptions;

/**
 *
 * @author arthur
 */
public class MoveException extends Exception
{

    /**
     * Creates a new instance of <code>MoveException</code> without detail
     * message.
     */
    public MoveException()
    {
    }

    /**
     * Constructs an instance of <code>MoveException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MoveException(String msg)
    {
        super(msg);
    }
}
