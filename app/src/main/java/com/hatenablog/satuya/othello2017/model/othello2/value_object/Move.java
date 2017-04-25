package com.hatenablog.satuya.othello2017.model.othello2.value_object;

import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.other.PlayerType;

/**
 * Created by Shusei on 2017/04/21.
 */

public class Move extends Disc {

    private PlayerType playerType = null;

    public Move( int x, int y, Color color, PlayerType playerType ) {

        super( x, y, color );
        this.playerType = playerType;
    }

    public Move( Disc disc, PlayerType playerType ) {

        this( disc.getX(), disc.getY(), disc.getColor(), playerType );
    }

    public PlayerType getPlayerType() {

        return this.playerType;
    }

    @Override
    public Move clone() {

        Move move = null;
        move = (Move) super.clone();
        move.playerType = this.playerType;

        return move;
    }
}
