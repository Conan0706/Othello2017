package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.mode_state.GameModeState;

/**
 * Created by Shusei on 2017/04/04.
 */

public interface BoardManager {

    void init();

    void addObserver( BoardListener observer );
    void deleteObserver( BoardListener observer );

    boolean put( Point point );
    boolean undo();
    void uiFinish();

    Board getBoard();

    void setMode( int mode );
    void setModeState( GameModeState modeState );
}
