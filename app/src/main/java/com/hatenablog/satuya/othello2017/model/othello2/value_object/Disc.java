package com.hatenablog.satuya.othello2017.model.othello2.value_object;

import com.hatenablog.satuya.othello2017.model.othello2.type.Color;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by Shusei on 2017/04/21.
 */

public class Disc extends Point {

    private Color color = null;

    public Disc( int x, int y, Color color ) {

        super( x, y );
        this.color = color;
    }

    public Disc( Point point, Color color ) {

        this( point.getX(), point.getY(), color );
    }

    public Color getColor() {

        return this.color;
    }

    @Override
    public Disc clone() {

        Disc disc = null;
        disc = (Disc) super.clone();
        disc.color = this.color;

        return disc;
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
