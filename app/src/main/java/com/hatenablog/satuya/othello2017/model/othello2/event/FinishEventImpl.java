package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.engine.ColorStorage;
import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

/**
 * Created by Shusei on 2017/03/15.
 */

public class FinishEventImpl implements FinishEvent {

    private Player winner;
    private Player loser;
    private ColorStorage storage = null;

    public FinishEventImpl( Player winner, Player loser, ColorStorage storage ) {

        this.winner = winner;
        this.loser = loser;
        this.storage = storage;
    }

    @Override
    public Player getWinner() {
        return this.winner;
    }

    @Override
    public Player getLoser() {
        return this.winner;
    }

    @Override
    public int getScore( Player player ) {

        return storage.get( player.getColor() );
    }
}
