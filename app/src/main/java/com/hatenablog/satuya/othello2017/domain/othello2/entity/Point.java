package com.hatenablog.satuya.othello2017.domain.othello2.entity;

import com.hatenablog.satuya.othello2017.domain.othello2.exception.PointOutOfBoundsException;

import static com.hatenablog.satuya.othello2017.domain.othello2.utility.OthelloConstants.BOARD_SIZE;

/**
 * Created by Shusei on 2017/04/03.
 */

public class Point {

    protected int x, y;

    public Point( int x, int y ) throws PointOutOfBoundsException {

        if ( x >= BOARD_SIZE ) {
            throw new PointOutOfBoundsException( x );
        } else if ( y >= BOARD_SIZE ) {
            throw new PointOutOfBoundsException( y );
        }

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
