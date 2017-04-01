package com.hatenablog.satuya.othello2017.presentation.presenter;

import android.content.Intent;

import com.hatenablog.satuya.othello2017.presentation.activity.SettingActivity;

/**
 * Created by Shusei on 2017/02/25.
 */

public class StartPresenter {

    private com.hatenablog.satuya.othello2017.presentation.activity.StartActivity startActivity = null;

    public void startButtonClicked() {
        Intent intent = new Intent( startActivity, SettingActivity.class );
        startActivity.startActivity( intent );
    }

    public void setStartActivity( com.hatenablog.satuya.othello2017.presentation.activity.StartActivity activity ) {

        this.startActivity = activity;
    }
}
