package com.hatenablog.satuya.othello2017.di.component;

import android.support.v7.app.AppCompatActivity;

import com.hatenablog.satuya.othello2017.presentation.activity.GameActivity;
import com.hatenablog.satuya.othello2017.presentation.fragment.GameFragment;
import com.hatenablog.satuya.othello2017.presentation.view.GameView;

/**
 * Created by Shusei on 2017/03/20.
 */

public interface PresentationComponent {

    void inject( GameFragment fragment );
}
