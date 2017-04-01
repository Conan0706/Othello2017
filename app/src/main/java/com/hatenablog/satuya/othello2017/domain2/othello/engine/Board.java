package com.hatenablog.satuya.othello2017.domain2.othello.engine;

import com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Point;

import java.util.ArrayList;

/**
 * Created by Shusei on 2017/03/13.
 */

public interface Board {

    void init();

    int countDisc( int color );
    int getColor( int x, int y );
    int getColor( Point point );
    int getCurrentColor();
    int getTurns();

    ArrayList<Disc> getPuttablePos();
    ArrayList<Disc> getUpdateDiscs();

    boolean isGameOver();
    boolean pass();
    boolean put( Point point );
    boolean undo();
}
