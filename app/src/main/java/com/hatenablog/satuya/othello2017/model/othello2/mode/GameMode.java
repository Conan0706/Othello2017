package com.hatenablog.satuya.othello2017.model.othello2.mode;

import com.hatenablog.satuya.othello2017.model.othello.entity.Point;

/**
 * Created by Shusei on 2017/04/04.
 */

public interface GameMode {

    void put( Point point );
    void undo();

    void changeMode();
}
