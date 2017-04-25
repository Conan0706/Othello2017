package com.hatenablog.satuya.othello2017.model.othello2.mode_state;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello2.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello2.other.GameMode;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;

/**
 * Created by Shusei on 2017/04/04.
 */

public interface GameModeState {

    boolean put( BoardManager manager, Board board, Move move );
    boolean undo( BoardManager manager, Board board );
    GameMode getMode();
}
