package com.hatenablog.satuya.othello2017.domain.othello2.entity;

/**
 * Created by Shusei on 2017/04/03.
 */

public class Point {

    protected int x, y;

    public Point( int x, int y ) {

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
