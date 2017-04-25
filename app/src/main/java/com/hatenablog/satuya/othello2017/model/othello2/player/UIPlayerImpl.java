package com.hatenablog.satuya.othello2017.model.othello2.player;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello2.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;

/**
 * Created by Shusei on 2017/04/23.
 */

public class UIPlayerImpl implements UIPlayer {

    private PlayerData playerData = null;
    private boolean isTurn;

    public UIPlayerImpl( PlayerData playerData ) {

        this.playerData = playerData;

        if ( playerData.getColor() == Color.BLACK ) {
            isTurn = true;
        } else {
            isTurn = false;
        }
    }

    @Override
    public void onTurn() {

        this.isTurn = true;
    }

    @Override
    public PlayerData getPlayerData() {
        return this.playerData;
    }

    @Override
    public void put( BoardManager manager, Point point ) {

        if ( isTurn ) {
            this.isTurn = false;
            manager.put(
                    new Move( point.getX(), point.getY(),
                            this.playerData.getColor(), this.playerData.getPlayerType() ) );
        }
    }

    @Override
    public boolean canPut( BoardManager manager, Point point ) {

        boolean canPut = manager.check(
                new Move( point.getX(), point.getY(),
                        this.playerData.getColor(), this.playerData.getPlayerType() ) );

        return canPut;
    }
}
