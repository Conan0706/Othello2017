package com.hatenablog.satuya.othello2017.presentation.presenter;

import android.view.View;

import com.hatenablog.satuya.othello2017.model.othello.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello.event.FinishEvent;
import com.hatenablog.satuya.othello2017.model.othello.event.PassEvent;
import com.hatenablog.satuya.othello2017.model.othello.event.PutEvent;
import com.hatenablog.satuya.othello2017.model.othello.event.TryWrongPosPutEvent;
import com.hatenablog.satuya.othello2017.model.othello.observer.BoardObserver;
import com.hatenablog.satuya.othello2017.presentation.view.GameView;
import com.hatenablog.satuya.othello2017.usecase.PosInputUseCase;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

/**
 * Created by Shusei on 2017/03/15.
 */

public class GamePresenterImpl implements GamePresenter, BoardObserver {

    private GameView view = null;

    private PosInputUseCase useCase = null; //TODO null
    private BoardManager manager = null; //TODO null

    @Inject
    public GamePresenterImpl( PosInputUseCase useCase, BoardManager manager ) {

        this.useCase = useCase;
        this.manager = manager;
        this.manager.addObserver( this );
    }

    @Override
    public void setGameView( GameView view ) {

        this.view = view;
    }

    @Override
    public void onUIPutFinished() {

        this.useCase.onUIPutFinished();
    }

    @Override
    public void onPut( PutEvent event ) {

        Disc disc = event.getPutDisc();
//        view.putDisc( disc );

        ArrayList<Disc> turnDiscs = event.getTurnDiscs();

        Iterator<Disc> iterator = turnDiscs.iterator();

        while ( iterator.hasNext() ) {
            Disc turnDisc = iterator.next();
//            view.turnDisc( turnDisc );
        }
    }

    @Override
    public void onPassed( PassEvent event ) {

        Color color = event.getPassPlayerColor();
        String colorStr = convertColorToJapaneseStr( color );

        view.showPassed( "色:" + colorStr + "がパスしました。" );
    }

    @Override
    public void onFinished( FinishEvent event ) {

        Color color = event.getWinnerColor();
        String colorStr = convertColorToJapaneseStr( color );

        view.showResult( colorStr + "が勝ちました。" );
    }

    @Override
    public void onTryWrongPosPut( TryWrongPosPutEvent event ) {

        view.showWrongPosPut( event.getWrongColor().toString() + "は" +
                event.getWrongPoint().x + "," + event.getWrongPoint().y + "には置けません。" );
    }

    private String convertColorToJapaneseStr( Color color ) {

        String result = null;
        if ( color == Color.BLACK ) {
            result = "黒";
        } else if ( color == Color.WHITE ) {
            result = "白";
        }

        return result;
    }

    @Override
    public void onClick( View view ) {

        Point point = (Point) view.getTag();
        useCase.onClick( point );
    }
}
