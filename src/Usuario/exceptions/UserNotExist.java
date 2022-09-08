/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Usuario.exceptions;

/**
 *
 * @author angel
 */
public class UserNotExist extends RuntimeException {

    /**
     * Creates a new instance of <code>UserNotExist</code> without detail
     * message.
     */
    public UserNotExist() {
    }

    /**
     * Constructs an instance of <code>UserNotExist</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UserNotExist(String msg) {
        super(msg);
    }
}
