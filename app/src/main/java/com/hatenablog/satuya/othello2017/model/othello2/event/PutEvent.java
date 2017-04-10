package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

import java.util.ArrayList;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface PutEvent {

    Player getPutPlayer();

    Disc getPutDisc(); //置いたところ

    ArrayList<Disc> getTurnDiscs(); //返ったところ

    ArrayList<Disc> getUpdateDiscs(); //置いたところ+返ったところ

    int getDiscNumber( int color ); //引数の色のdiscの数
}
