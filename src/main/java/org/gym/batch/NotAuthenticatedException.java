/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gym.batch;

/**
 *
 * @author anantha
 */
public class NotAuthenticatedException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAuthenticatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotAuthenticatedException(Throwable cause) {
        super(cause);
    }

    public NotAuthenticatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAuthenticatedException(String message) {
        super(message);
    }

    public NotAuthenticatedException() {
    }
    
    
    
}
