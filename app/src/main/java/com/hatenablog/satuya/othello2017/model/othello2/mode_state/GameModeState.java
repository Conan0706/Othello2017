package com.hatenablog.satuya.othello2017.model.othello2.mode_state;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.BoardManager;

/**
 * Created by Shusei on 2017/04/04.
 */

public interface GameModeState {

    boolean put( Board board, Point point );
    boolean undo( Board board);

    void changeMode( BoardManager manager, int mode );

    void uiFinish();

    int getMode();
}
