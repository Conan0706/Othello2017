package com.hatenablog.satuya.othello2017.domain2.othello.event;

import com.hatenablog.satuya.othello2017.domain2.othello.entity.Color;

/**
 * Created by Shusei on 2017/03/15.
 */

public class PassEventImpl implements PassEvent {

    private Color color = null;

    public PassEventImpl( Color color ) {

        this.color = color;
    }

    @Override
    public Color getPassPlayerColor() {
        return this.color;
    }
}
