/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.exceptions;

/**
 *
 * @author Matus
 */
public class UserCannotBeCreatedException extends DocServerException {

    private static final long serialVersionUID = -3387516993124229948L + 2;

    public UserCannotBeCreatedException(String message) {
        super(message);
    }
}
