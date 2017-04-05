package com.hatenablog.satuya.othello2017.model.othello2.mode_state;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.BoardManager;

import static com.hatenablog.satuya.othello2017.model.othello2.OthelloConstants.COMPUTER_MODE;

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
    public boolean put( Board board, Point point ) {
        return false;
    }

    @Override
    public boolean undo( Board board ) {
        return false;
    }

    @Override
    public void changeMode( BoardManager boardManager, int mode ) {

        if ( mode == COMPUTER_MODE ) {
            boardManager.setModeState( ComputerModeState.getInstance() );
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
