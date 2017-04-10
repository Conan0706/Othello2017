package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.entity.Move;
import com.hatenablog.satuya.othello2017.model.othello2.mode_state.GameModeState;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

/**
 * Created by Shusei on 2017/04/04.
 */

public interface BoardManager {

    void init();

    void addObserver( BoardListener observer );
    void deleteObserver( BoardListener observer );

    boolean put( Move move );
    boolean undo( Player player );
    void uiFinish( Player player );

    Board getBoard();

    void setMode( int mode );
    void setModeState( GameModeState modeState );
}
