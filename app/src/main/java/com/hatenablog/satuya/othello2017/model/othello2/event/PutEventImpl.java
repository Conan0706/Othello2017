package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Shusei on 2017/03/15.
 */

public class PutEventImpl implements PutEvent {

    @Override
    public Player getPutPlayer() {
        return null;
    }

    @Override
    public Disc getPutDisc() {
        return null;
    }

    @Override
    public ArrayList<Disc> getTurnDiscs() {
        return null;
    }

    @Override
    public ArrayList<Disc> getUpdateDiscs() {
        return null;
    }

    @Override
    public int getDiscNumber( int color ) {
        return 0;
    }
}
