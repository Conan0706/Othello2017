package com.hatenablog.satuya.othello2017.model.othello2;

/**
 * Created by Shusei on 2017/04/05.
 */

public interface BoardState {

    int getCurrentColor();
    int nextPlayer();
    int getColorValue( int color );
    int getTurn();
}
