package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.mode_state.GameModeState;

/**
 * Created by Shusei on 2017/04/05.
 */

public class BoardManagerImpl implements BoardManager {

    protected BoardNotifier notifier = null;

    protected Board board = null;
    protected GameModeState modeState = null;

    public BoardManagerImpl( Board board, GameModeState modeState ) {

        this.notifier = new BoardNotifierImpl();

        this.board = board;
        this.modeState = modeState;
    }

    @Override
    public void init() {

        this.notifier = new BoardNotifierImpl();
        this.board.init();
    }

    @Override
    public void addObserver( BoardListener listener ) {

        this.notifier.addListener( listener );
    }

    @Override
    public void deleteObserver( BoardListener listener ) {

        this.notifier.deleteListener( listener );
    }

    @Override
    public boolean put( Point point ) {

        this.modeState.put( this.board, point );

        return false;
    }

    @Override
    public boolean undo() {

        this.modeState.undo( this.board );

        return false;
    }

    @Override
    public void uiFinish() {

        this.modeState.uiFinish();
    }

    @Override
    public Board getBoard() {

        return this.board;
    }

    public void setMode( int mode ) { //外部クラス

        this.modeState.changeMode( this, mode );
    }

    @Override
    public void setModeState( GameModeState modeState ) { //Stateクラス

        this.modeState = modeState;
    }


}
