package com.hatenablog.satuya.othello2017.model.engine.point;

public class Point {

    public int x;
    public int y;

    public Point() {
        this( 0, 0 );
    }

    public Point( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Point clone() {

        Point point = new Point( this.x, this.y );
        return point;
    }
}
