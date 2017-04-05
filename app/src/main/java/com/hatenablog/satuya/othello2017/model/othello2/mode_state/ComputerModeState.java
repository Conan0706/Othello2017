package com.hatenablog.satuya.othello2017.model.othello2.mode_state;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.BoardManager;

import static com.hatenablog.satuya.othello2017.model.othello2.OthelloConstants.HUMAN_MODE;

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
    public boolean put( Board board, Point point ) {
        return false;
    }

    @Override
    public boolean undo( Board board ) {
        return false;
    }

    @Override
    public void changeMode( BoardManager boardManager, int mode ) {

        if ( mode == HUMAN_MODE ) {
            boardManager.setModeState( HumanModeState.getInstance() );
        }
    }

    @Override
    public void uiFinish() {

    }

    @Override
    public int getMode() {
        return 0;
    }
}
