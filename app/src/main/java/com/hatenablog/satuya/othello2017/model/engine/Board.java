package com.hatenablog.satuya.othello2017.model.engine;

import com.hatenablog.satuya.othello2017.model.engine.point.DiscForCalc;
import com.hatenablog.satuya.othello2017.model.engine.point.PointForCalc;

import java.util.ArrayList;

/**
 * Created by Shusei on 2017/03/13.
 */

public interface Board {

    void init();

    int countDisc( int color );

    int getColor( int x, int y );

    int getColor( PointForCalc pointForCalc );

    int getCurrentColor();

    int getTurns();

    ColorStorage getColorStorage();

    ArrayList<DiscForCalc> getMovablePos();

    ArrayList<DiscForCalc> getUpdateDiscs();

    boolean isGameOver();

    boolean pass();

    boolean put( PointForCalc pointForCalc );

    boolean undo();
}
