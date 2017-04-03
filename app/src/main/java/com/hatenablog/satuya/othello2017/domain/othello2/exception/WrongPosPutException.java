package com.hatenablog.satuya.othello2017.domain.othello2.exception;

import com.hatenablog.satuya.othello2017.domain.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.domain.othello2.entity.Point;

/**
 * Created by Shusei on 2017/04/03.
 */

public class WrongPosPutException extends OthelloException {


    public WrongPosPutException( Point point ) {
        super( "x: " + point.getX() + " y: " + point.getY()
                + "\nには置けません。" );
    }
}
