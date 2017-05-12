package com.hatenablog.satuya.othello2017.model.othello2.value_object;

import com.hatenablog.satuya.othello2017.model.othello2.type.Color;
import com.hatenablog.satuya.othello2017.model.othello2.type.PlayerType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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

    @Override
    public boolean equals( Object o ) {

        return EqualsBuilder.reflectionEquals( this, o );
    }

    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode( this );
    }
}
