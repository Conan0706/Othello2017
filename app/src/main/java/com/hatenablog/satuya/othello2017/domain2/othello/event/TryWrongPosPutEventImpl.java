package com.hatenablog.satuya.othello2017.domain2.othello.event;

import com.hatenablog.satuya.othello2017.domain2.othello.entity.Color;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Point;

/**
 * Created by Shusei on 2017/03/15.
 */

public class TryWrongPosPutEventImpl implements TryWrongPosPutEvent {

    private Point point = null;
    private Color color = null;

    public TryWrongPosPutEventImpl( Point point, Color wrongColor ) {
        this.point = point;
        this.color = wrongColor;
    }

    @Override
    public Point getWrongPoint() {
        return this.point;
    }

    @Override
    public Color getWrongColor() {
        return this.color;
    }
}
