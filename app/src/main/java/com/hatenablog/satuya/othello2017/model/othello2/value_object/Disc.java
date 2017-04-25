package com.hatenablog.satuya.othello2017.model.othello2.value_object;

import com.hatenablog.satuya.othello2017.model.othello2.other.Color;

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
}
