package com.hatenablog.satuya.othello2017.model.othello2.player;

import com.hatenablog.satuya.othello2017.model.othello2.manager.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello2.PutNotifier;
import com.hatenablog.satuya.othello2017.model.othello2.type.Color;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.PlayerData;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;

/**
 * Created by Shusei on 2017/04/23.
 */

public class UIPlayerImpl implements UIPlayer {

    private PlayerData playerData = null;
    private boolean isTurn;

    private PutNotifier putNotifier = null;

    public UIPlayerImpl( PlayerData playerData ) {

        this.playerData = playerData;

        if ( playerData.getColor() == Color.BLACK ) {
            this.isTurn = true;
//            this.putNotifier.onTurn( this );
        } else {
            this.isTurn = false;
        }
    }

    @Override
    public void onTurn() {

        this.isTurn = true;
        this.putNotifier.onTurn( this );
    }

    @Override
    public PlayerData getPlayerData() {
        return this.playerData;
    }

    @Override
    public void setPutNotifier( PutNotifier putNotifier ) {

        this.putNotifier = putNotifier;
        if ( playerData.getColor() == Color.BLACK ) {
            this.putNotifier.onTurn( this );
        }
    }

    @Override
    public void put( BoardManager manager, Point point ) {

        if ( isTurn ) {
            this.isTurn = !
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
