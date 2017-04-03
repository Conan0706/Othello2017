package com.hatenablog.satuya.othello2017.presentation.delegate.init_board;

import android.widget.ImageButton;

import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;

/**
 * Created by Shusei on 2017/04/02.
 */

public interface InitBoardDelegate {

    int getLayoutID();
    void initBoard( final ImageButton[][] buttons, final GamePresenter presenter,
                    final int size );
}
