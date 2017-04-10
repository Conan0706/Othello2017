package com.hatenablog.satuya.othello2017.model.othello2.entity;

import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

/**
 * Created by Shusei on 2017/04/07.
 */

public class Move extends Disc {

    protected Player player = null;

    public Move( int x, int y, int color, Player player ) {

        super( x, y, color );

        this.player = player;
    }

    public Move( Point point, int color, Player player ) {

        this( point.x, point.y, color, player );
    }

    public Move( Disc disc, Player player ) {

        this( disc.x, disc.y, disc.color, player );
    }

    public Player getPlayer() {

        return this.player;
    }
}
