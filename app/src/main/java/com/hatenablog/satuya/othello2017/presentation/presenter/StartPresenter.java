package com.hatenablog.satuya.othello2017.presentation.presenter;

/**
 * Created by Shusei on 2017/02/25.
 */

public class StartPresenter {

    private com.hatenablog.satuya.othello2017.presentation.activity.StartActivity startActivity = null;

    public void startButtonClicked() {

        startActivity.moveGameView();
    }

    public void setStartActivity( com.hatenablog.satuya.othello2017.presentation.activity.StartActivity activity ) {

        this.startActivity = activity;
    }
}
