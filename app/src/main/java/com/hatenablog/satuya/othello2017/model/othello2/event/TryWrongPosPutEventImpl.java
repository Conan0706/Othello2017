package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

/**
 * Created by Shusei on 2017/03/15.
 */

public class TryWrongPosPutEventImpl implements TryWrongPosPutEvent {

    @Override
    public Point getWrongPoint() {
        return null;
    }

    @Override
    public Player getWrongPlayer() {
        return null;
    }
}
