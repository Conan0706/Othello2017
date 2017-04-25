package com.hatenablog.satuya.othello2017.model.othello2.value_object;

/**
 * Created by Shusei on 2017/04/21.
 */

public class Point implements Cloneable {

    private int x, y;

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

    @Override
    public Point clone() {

        Point point = null;
        try {
            point = (Point) super.clone();
            point.x = this.x;
            point.y = this.y;
        } catch ( CloneNotSupportedException e ) {
            e.printStackTrace();
        }

        return point;
    }
}
