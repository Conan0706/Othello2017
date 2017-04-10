package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.entity.Move;
import com.hatenablog.satuya.othello2017.model.othello2.mode_state.GameModeState;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

/**
 * Created by Shusei on 2017/04/05.
 */

public class BoardManagerImpl implements BoardManager {

    private BoardNotifier notifier = null;

    private Board board = null;
    private GameModeState modeState = null;

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
    public boolean put( Move move ) {

        boolean couldPut = this.modeState.put( this.board, move );

        return false;
    }

    @Override
    public boolean undo( Player player ) {

        this.modeState.undo( this.board );

        return false;
    }

    @Override
    public void uiFinish( Player player ) {

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
