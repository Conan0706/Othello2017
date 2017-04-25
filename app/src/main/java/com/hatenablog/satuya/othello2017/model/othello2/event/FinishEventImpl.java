package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.engine.ColorStorage;
import com.hatenablog.satuya.othello2017.model.othello2.BoardValueGroup;
import com.hatenablog.satuya.othello2017.model.othello2.OthelloUtilities;
import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.other.PlayerType;
import com.hatenablog.satuya.othello2017.model.othello2.player.PlayerData;

/**
 * Created by Shusei on 2017/03/15.
 */

public class FinishEventImpl implements FinishEvent {

    private BoardValueGroup boardValueGroup = null;

    private PlayerData winner = null;
    private PlayerData loser = null;
    private ColorStorage storage = null;

    public FinishEventImpl( BoardValueGroup group, PlayerData winner, PlayerData loser, ColorStorage storage ) {

        this.boardValueGroup = group;

        this.winner = winner;
        this.loser = loser;
        this.storage = storage;
    }

    @Override
    public PlayerData getWinner() {
        return winner;
    }

    @Override
    public PlayerData getLoser() {
        return loser;
    }

    @Override
    public int getScore( Color color ) {

        return storage.get( OthelloUtilities.color2ColorCode( color ) );
    }

    @Override
    public BoardValueGroup getBoardValueGroup() {

        return this.boardValueGroup;
    }
}
