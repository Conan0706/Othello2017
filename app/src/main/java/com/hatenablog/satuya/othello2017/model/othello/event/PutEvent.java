package com.hatenablog.satuya.othello2017.model.othello.event;

import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;

import java.util.ArrayList;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface PutEvent {

    Color getPutPlayerColor();

    Disc getPutDisc(); //置いたところ

    ArrayList<Disc> getTurnDiscs(); //返ったところ

    ArrayList<Disc> getUpdateDiscs(); //置いたところ+返ったところ

    int getDiscNumber( int color ); //引数の色のdiscの数
}
