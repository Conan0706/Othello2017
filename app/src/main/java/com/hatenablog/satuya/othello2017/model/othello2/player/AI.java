package com.hatenablog.satuya.othello2017.model.othello2.player;

import static com.hatenablog.satuya.othello2017.model.othello2.OthelloConstants.COMPUTER;

/**
 * Created by Shusei on 2017/04/06.
 */

public class AI implements Player {

    private int color;

    public AI( int color ) {

        this.color = color;
    }

    @Override
    public int getPlayerType() {
        return COMPUTER;
    }

    @Override
    public int getColor() {
        return this.color;
    }
}
