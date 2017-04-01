package com.hatenablog.satuya.othello2017.unused;

import com.hatenablog.satuya.othello2017.domain2.othello.entity.Color;
import com.hatenablog.satuya.othello2017.domain2.othello.BoardManager;
import com.hatenablog.satuya.othello2017.domain2.othello.player.Player;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Point;

/**
 * Created by Shusei on 2017/03/01.
 */

public class TransferPlayer implements Player {

    private TransferSource source = null;
    private Color color = null;

    public TransferPlayer( TransferSource source, Color color ) {

        this.source = source;
        this.color = color;
    }

    public void transferPut( Point point ) {

    }

    @Override
    public void onTurn() {

        this.source.onTurn( this.color );
    }

    @Override
    public void setManager( BoardManager manager ) {

    }

//    @Override
//    public Color getColor() {
//        return color;
//    }
}
