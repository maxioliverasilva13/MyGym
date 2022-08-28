/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Usuario.exceptions;

/**
 *
 * @author angel
 */


@SuppressWarnings("serial")
public class UserAlreadyNickExist extends Exception {

    /**
     * Creates a new instance of <code>UserAlreadyNickExist</code> without
     * detail message.
     */
    public UserAlreadyNickExist() {
    }

    /**
     * Constructs an instance of <code>UserAlreadyNickExist</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserAlreadyNickExist(String msg) {
        super(msg);
    }
}
