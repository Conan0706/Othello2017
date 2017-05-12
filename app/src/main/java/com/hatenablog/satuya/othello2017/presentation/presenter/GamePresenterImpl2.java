package com.hatenablog.satuya.othello2017.presentation.presenter;

import android.view.View;

import com.hatenablog.satuya.othello2017.model.othello2.BoardListener;
import com.hatenablog.satuya.othello2017.model.othello2.usecase.PutUseCase;
import com.hatenablog.satuya.othello2017.model.othello2.event.FinishEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.PassEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.PutEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.UndoEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.WrongMoveEvent;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Disc;
import com.hatenablog.satuya.othello2017.presentation.view.GameView;

import javax.inject.Inject;

/**
 * Created by Shusei on 2017/04/23.
 */

public class GamePresenterImpl2 implements GamePresenter, BoardListener {

    private GameView gameView = null;
    private PutUseCase putUseCase = null;

    private boolean isFirst = true;

    @Inject
    public GamePresenterImpl2( PutUseCase putUseCase ) {

        this.putUseCase = putUseCase;
    }

    @Override
    public void onUndoButtonClick() {


    }

    @Override
    public void onPut( View view ) {

        if ( isFirst ) {
            isFirst = false;
            this.putUseCase.addBoardListener( this );
        }

        Object o = view.getTag();

        Disc disc = null;
        if ( o instanceof Disc ) {
            disc = (Disc) o;
        } else {
            return;
        }

        putUseCase.put( disc );
    }

    @Override
    public void setGameView( GameView view ) {

        this.gameView = view;
    }

    @Override
    public void onFinish( FinishEvent event ) {

        this.gameView.showResult( event.getWinner().toString() );
    }

    @Override
    public void onPass( PassEvent event ) {

    }

    @Override
    public void onPut( PutEvent event ) {

        this.gameView.putDisc( event.getMove() );

        for ( Disc disc : event.getTurnDiscs() ) {
            this.gameView.turnDisc( disc );
        }
    }

    @Override
    public void onUndo( UndoEvent event ) {

    }

    @Override
    public void onWrongPut( WrongMoveEvent event ) {

    }
}
