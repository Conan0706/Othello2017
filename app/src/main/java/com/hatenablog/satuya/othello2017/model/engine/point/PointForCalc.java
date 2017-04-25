package com.hatenablog.satuya.othello2017.model.engine.point;

import org.apache.commons.lang.builder.EqualsBuilder;

public class PointForCalc {

    public int x;
    public int y;

    public PointForCalc() {
        this( 0, 0 );
    }

    public PointForCalc( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals( Object o ) {

        return EqualsBuilder.reflectionEquals( this, o );
    }
}
