package com.hatenablog.satuya.othello2017.domain.othello.mode;

import com.hatenablog.satuya.othello2017.domain.othello.entity.Point;

/**
 * Created by Shusei on 2017/04/04.
 */

public interface GameMode {

    void put( Point point );
    void undo();
}
