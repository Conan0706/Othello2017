package com.hatenablog.satuya.othello2017.model.othello2.mode_state;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello2.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello2.OthelloUtilities;
import com.hatenablog.satuya.othello2017.model.othello2.other.EventType;
import com.hatenablog.satuya.othello2017.model.othello2.other.GameMode;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;

import static com.hatenablog.satuya.othello2017.model.othello2.other.EventType.FINISH;
import static com.hatenablog.satuya.othello2017.model.othello2.other.EventType.PASS;
import static com.hatenablog.satuya.othello2017.model.othello2.other.EventType.PUT;
import static com.hatenablog.satuya.othello2017.model.othello2.other.EventType.UNDO;
import static com.hatenablog.satuya.othello2017.model.othello2.other.EventType.WRONG_PUT;
import static com.hatenablog.satuya.othello2017.model.othello2.other.GameMode.HUMAN_MODE;

/**
 * Created by Shusei on 2017/04/04.
 */

public class HumanModeState implements GameModeState {

    private static GameModeState humanModeState = new HumanModeState();

    private HumanModeState() {}

    public static GameModeState getInstance() {

        return humanModeState;
    }

    @Override
    public boolean put( BoardManager manager, Board board, Move move ) {

        boolean canPut = board.put( OthelloUtilities.Disc2ForCalcDisc( move ) );

        if ( !canPut ) {
            manager.igniteEvent( WRONG_PUT );
            return canPut;
        } else {
            manager.igniteEvent( PUT );
        }

        if ( board.isGameOver() ) {
            manager.igniteEvent( FINISH );
            return canPut;
        }

        if ( board.pass() ) {
            manager.igniteEvent( PASS );
        }

        return canPut;
    }

    @Override
    public boolean undo( BoardManager manager, Board board ) {

        boolean canUndo = board.undo();

        if ( canUndo ) {
            manager.igniteEvent( UNDO );
        }

        return canUndo;
    }

    @Override
    public GameMode getMode() {
        return HUMAN_MODE;
    }
}
