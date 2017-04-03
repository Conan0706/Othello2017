package com.hatenablog.satuya.othello2017.domain.othello.player;

import com.hatenablog.satuya.othello2017.domain.othello.BoardManager;
import com.hatenablog.satuya.othello2017.domain.othello.entity.Color;
import com.hatenablog.satuya.othello2017.domain.othello.entity.Point;
import com.hatenablog.satuya.othello2017.domain.othello.player.Player;

/**
 * Created by Shusei on 2017/03/19.
 */

public class UIPlayer implements Player {

    private Color color = null;

    private boolean isTurn = false;
    private BoardManager boardManager = null; //TODO null

    public UIPlayer( Color color ) {

        this.color = color;

        if ( color == Color.BLACK ) {
            isTurn = true;
        } else {
            isTurn = false;
        }
    }

    public void putClicked( Point point ) {

        if ( this.isTurn ) {
            boolean hasPut = boardManager.put( point );

            if ( hasPut ) {
                this.isTurn = false;
            }
        }
    }

    @Override
    public void onTurn() {

        this.isTurn = true;
    }

    @Override
    public void setManager( BoardManager manager ) {

        this.boardManager = manager;
    }
}
