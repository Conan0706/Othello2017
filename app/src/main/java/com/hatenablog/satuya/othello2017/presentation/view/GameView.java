package com.hatenablog.satuya.othello2017.presentation.view;

import com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;

/**
 * Created by Shusei on 2017/03/05.
 */

public interface GameView {

    void initBoard();

    void showBoard();

    void hideBoard();

    //    void setButtonColor( Stone stone );
    void putDisc( Disc disc );

    void turnDisc( Disc turnDisc );

    void showResult( String result );

    void showPassed( String text );

    void showWrongPosPut( String text );

    GamePresenter getPresenter();
}
