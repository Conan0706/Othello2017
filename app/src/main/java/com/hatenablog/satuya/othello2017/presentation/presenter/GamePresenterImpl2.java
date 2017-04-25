package com.hatenablog.satuya.othello2017.presentation.presenter;

import android.view.View;

import com.hatenablog.satuya.othello2017.model.othello2.BoardListener;
import com.hatenablog.satuya.othello2017.model.othello2.event.FinishEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.PassEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.PutEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.UndoEvent;
import com.hatenablog.satuya.othello2017.model.othello2.event.WrongMoveEvent;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Disc;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;
import com.hatenablog.satuya.othello2017.presentation.view.GameView;

/**
 * Created by Shusei on 2017/04/23.
 */

public class GamePresenterImpl2 implements GamePresenter, BoardListener {

    @Override
    public void onClick( View view ) {

        Object o = view.getTag();

        if ( o instanceof Disc ) {
            Disc disc = (Disc) o;
        }


    }

    @Override
    public void setGameView( GameView view ) {

    }

    @Override
    public void onUIPutFinished() {

    }

    @Override
    public void onFinish( FinishEvent event ) {

    }

    @Override
    public void onPass( PassEvent event ) {

    }

    @Override
    public void onPut( PutEvent event ) {

    }

    @Override
    public void onUndo( UndoEvent event ) {

    }

    @Override
    public void onWrongPut( WrongMoveEvent event ) {

    }
}
