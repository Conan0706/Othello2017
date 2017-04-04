package com.hatenablog.satuya.othello2017.presentation.presenter;

import android.view.View;

import com.hatenablog.satuya.othello2017.presentation.view.GameView;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface GamePresenter {

    void onClick( View view );
    void setGameView( GameView view );

    void onUIPutFinished();
}
