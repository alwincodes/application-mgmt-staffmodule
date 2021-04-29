package com.sgca.exception;
/**
 * 
 * @author Alwin Mathew
 * @version 1.0
 *
 */
public class SGCAException extends Exception {
    private static final long serialVersionUID = 1666L;

    public SGCAException(Exception argException){
        super(argException);
    }
}
