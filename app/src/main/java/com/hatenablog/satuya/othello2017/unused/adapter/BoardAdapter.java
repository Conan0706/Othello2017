package com.hatenablog.satuya.othello2017.unused.adapter;

import com.hatenablog.satuya.othello2017.domain2.othello.engine.Board;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Disc;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Point;

import java.util.ArrayList;

/**
 * Created by Shusei on 2017/03/15.
 */

public class BoardAdapter implements Board {
//未完成　完成させる予定なし　当初はBoardImplをAdaptする予定だったがメソッド名書き換えた方が早いことに気がついた

    private com.hatenablog.satuya.othello2017.domain2.othello.engine.BoardImpl boardImpl = null;

    public BoardAdapter() {
        this.boardImpl = new com.hatenablog.satuya.othello2017.domain2.othello.engine.BoardImpl();
    }

    @Override
    public void init() {
        this.boardImpl.init();
    }

    @Override
    public int countDisc( int color ) { //TODO 引数変更  int color 完了 3/15 2:49
        return 0;
    }

    @Override
    public int getColor( int x, int y ) {
        return 0;
    }

    @Override
    public int getColor( Point point ) {
        return 0;
    }

    @Override
    public int getCurrentColor() {
        return 0;
    }

    @Override
    public int getTurns() {
        return 0;
    }


    @Override
    public ArrayList<Disc> getPuttablePos() {
        return null;
    }

    @Override
    public ArrayList<Disc> getUpdateDiscs() {
        return null;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public boolean pass() {
        return false;
    }

    @Override
    public boolean put( Point point ) {
        return false;
    }

    @Override
    public boolean undo() {
        return false;
    }
}
