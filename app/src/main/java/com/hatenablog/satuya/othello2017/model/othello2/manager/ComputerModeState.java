package com.hatenablog.satuya.othello2017.model.othello2.manager;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello2.OthelloUtilities;
import com.hatenablog.satuya.othello2017.model.othello2.type.GameMode;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;

import static com.hatenablog.satuya.othello2017.model.othello2.type.GameMode.COMPUTER_MODE;

/**
 * Created by Shusei on 2017/04/04.
 */

public class ComputerModeState implements GameModeState {

    private static GameModeState computerModeState = new ComputerModeState();

    private ComputerModeState() {}

    public static GameModeState getInstance() {

        return computerModeState;
    }

    @Override
    public boolean put( BoardManager manager, Board board, Move move ) {

        boolean canPut = board.put( OthelloUtilities.Disc2ForCalcDisc( move ) );
        return false;
    }

    @Override
    public boolean undo( BoardManager manager, Board board ) {
        return false;
    }

    @Override
    public GameMode getMode() {
        return COMPUTER_MODE;
    }
}
