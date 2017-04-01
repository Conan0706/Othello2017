package com.hatenablog.satuya.othello2017.domain2.othello.event;

import com.hatenablog.satuya.othello2017.domain2.othello.entity.Color;

/**
 * Created by Shusei on 2017/03/15.
 */

public class FinishEventImpl implements FinishEvent {

    Color winner = null;
    Color loser = null;
    int score = -1;

    public FinishEventImpl( Color winner, Color loser, int score ) {

        this.winner = winner;
        this.loser = loser;
        this.score = score;
    }

    @Override
    public Color getWinnerColor() {
        return this.winner;
    }

    @Override
    public Color getLoserColor() {
        return this.loser;
    }

    @Override
    public int getScore() {
        return this.score;
    }
}
