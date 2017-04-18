package com.hatenablog.satuya.othello2017.model.othello2.value_object;

import static com.hatenablog.satuya.othello2017.model.othello2.OthelloConstants.EMPTY;

public class Disc extends Point {

    protected int color;

    public Disc() {

        this( 0, 0, EMPTY );
    }

    public Disc( int x, int y, int color ) {

        super( x, y );

        this.color = color;
    }

    public Disc( Point point, int color ) {

        this( point.x, point.y, color );
    }

    @Override
    public Disc clone() {

        Disc disc = new Disc( super.x, super.y, this.color );
        return disc;
    }

    public int getColor() {

        return this.color;
    }
}
