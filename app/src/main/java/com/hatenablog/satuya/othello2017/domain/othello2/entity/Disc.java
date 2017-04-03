package com.hatenablog.satuya.othello2017.domain.othello2.entity;

import com.hatenablog.satuya.othello2017.domain.othello2.exception.PointOutOfBoundsException;
import com.hatenablog.satuya.othello2017.domain.othello2.exception.WrongColorException;

import static com.hatenablog.satuya.othello2017.domain.othello2.utility.OthelloConstants.BLACK;
import static com.hatenablog.satuya.othello2017.domain.othello2.utility.OthelloConstants.EMPTY;
import static com.hatenablog.satuya.othello2017.domain.othello2.utility.OthelloConstants.WALL;
import static com.hatenablog.satuya.othello2017.domain.othello2.utility.OthelloConstants.WHITE;

/**
 * Created by Shusei on 2017/04/03.
 */

public class Disc extends Point {

    protected int color;

    public Disc( int x, int y, int color ) throws PointOutOfBoundsException, WrongColorException {
        super( x, y );

        if ( color != WALL && color != BLACK && color != EMPTY && color != WHITE ) {
            throw new WrongColorException( color );
        }

        this.color = color;
    }

    public int getColor() {
        return this.color;
    }
}
