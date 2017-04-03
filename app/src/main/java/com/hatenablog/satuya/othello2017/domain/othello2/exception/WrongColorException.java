package com.hatenablog.satuya.othello2017.domain.othello2.exception;

/**
 * Created by Shusei on 2017/04/03.
 */

public class WrongColorException extends OthelloException {

    public WrongColorException( int color ) {
        super( "color: " + color + " は不正です。" );
    }
}
