package com.hatenablog.satuya.othello2017.model.othello2.player;

import com.hatenablog.satuya.othello2017.model.othello.entity.Point;

/**
 * Created by Shusei on 2017/04/06.
 */

public interface UIPlayer extends Player {

    void put( Point point );
    void uiFinish();
}
