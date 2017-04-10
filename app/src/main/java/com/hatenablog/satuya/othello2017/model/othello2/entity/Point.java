package com.hatenablog.satuya.othello2017.model.othello2.entity;

public class Point {

    protected int x;
    protected int y;

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

    public int getX() {

        return this.x;
    }

    public int getY() {

        return this.y;
    }
}
