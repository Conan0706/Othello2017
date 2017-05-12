package com.hatenablog.satuya.othello2017.model.othello2.value_object;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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

    @Override
    public boolean equals( Object o ) {

        return EqualsBuilder.reflectionEquals( this, o );
    }

    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode( this );
    }
}
