package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface WrongMoveEvent extends Event {

    Move getWrongMove();
}
