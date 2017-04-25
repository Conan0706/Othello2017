package com.hatenablog.satuya.othello2017.presentation.view;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Disc;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;

/**
 * Created by Shusei on 2017/04/02.
 */

public interface GameView2 {

    void initBoard();
    void putDisc( final Disc disc );
    void turnDisc( final Disc disc );
    void onTurnEnd();

    void showResult();
    void showPassed();
    void showWrongPosPut();

    GamePresenter getGamePresenter();
}
