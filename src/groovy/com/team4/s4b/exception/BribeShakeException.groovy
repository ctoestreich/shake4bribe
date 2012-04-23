package com.team4.s4b.exception

/**
 * Exception that represents something that went wrong with a shake
 */
class BribeShakeException extends Exception {


    BribeShakeException(Exception exception){
        super(exception)
    }


    BribeShakeException(String message){
        super(message)
    }
}
