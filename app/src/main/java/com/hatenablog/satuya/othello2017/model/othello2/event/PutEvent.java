package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello2.type.Color;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Disc;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;

import java.util.ArrayList;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface PutEvent extends Event {

    Move getMove();
    ArrayList<Disc> getTurnDiscs(); //返ったところ
    ArrayList<Disc> getUpdateDiscs(); //置いたところ+返ったところ
    int getColorNumber( Color color ); //引数の色のdiscの数
}
