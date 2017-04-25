package com.hatenablog.satuya.othello2017.model.engine.point;

import org.apache.commons.lang.builder.EqualsBuilder;

import static com.hatenablog.satuya.othello2017.model.engine.OthelloConstants.EMPTY;

public class DiscForCalc extends PointForCalc {

    public int color;

    public DiscForCalc() {

        this( 0, 0, EMPTY );
    }

    public DiscForCalc( int x, int y, int color ) {

        super( x, y );

        this.color = color;
    }

    public DiscForCalc( PointForCalc pointForCalc, int color ) {

        this( pointForCalc.x, pointForCalc.y, color );
    }

    @Override
    public boolean equals( Object o ) {

        return EqualsBuilder.reflectionEquals( this, o );
    }
}
