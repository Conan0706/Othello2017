package com.hatenablog.satuya.othello2017.domain.othello2.entity;

/**
 * Created by Shusei on 2017/04/03.
 */

public class Disc extends Point {

    protected int color;

    public Disc( int x, int y, int color ) {
        super( x, y );
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }
}
