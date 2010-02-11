/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.docserver.exceptions;

/**
 *
 * @author Matus
 */
public class DocServerException extends Exception {

    static final long serialVersionUID = -3387516993124229948L + 1;

    public DocServerException() {
        super();
    }

    public DocServerException(String message) {
        super(message);
    }

    public DocServerException(Throwable cause) {
        super(cause);
    }

    public DocServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
