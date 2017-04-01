package com.hatenablog.satuya.othello2017.domain2.othello.entity;

public class Disc extends Point {

    public static final int WALL = 2; //配列のインデックスにする場合インクリメントして3
    public static final int BLACK = 1; //,,2
    public static final int EMPTY = 0; //,,1
    public static final int WHITE = -1; //,,0

    public int color;

    public Disc() {

        this( 0, 0, EMPTY );
    }

    public Disc( int x, int y, int color ) {

        super( x, y );

        this.color = color;
    }

    @Override
    public Disc clone() {

        Disc disc = new Disc( super.x, super.y, this.color );
        return disc;
    }
}
