package com.hatenablog.satuya.othello2017.domain.othello.event;

import com.hatenablog.satuya.othello2017.domain.othello.entity.Color;
import com.hatenablog.satuya.othello2017.domain.othello.entity.Point;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface TryWrongPosPutEvent {

    Point getWrongPoint();

    Color getWrongColor();
}
