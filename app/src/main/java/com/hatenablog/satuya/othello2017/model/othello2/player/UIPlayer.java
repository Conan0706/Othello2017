package com.hatenablog.satuya.othello2017.model.othello2.player;

import com.hatenablog.satuya.othello2017.model.othello2.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;

/**
 * Created by Shusei on 2017/04/06.
 */

public interface UIPlayer extends Player {

    void put( BoardManager manager, Point point );
    boolean canPut( BoardManager manager, Point point );
}
