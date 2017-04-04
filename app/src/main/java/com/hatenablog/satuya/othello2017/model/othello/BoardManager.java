package com.hatenablog.satuya.othello2017.model.othello;

import com.hatenablog.satuya.othello2017.model.othello.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello.observer.BoardObserver;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface BoardManager {

    void initBoard();

    void addObserver( BoardObserver observer );

    boolean put( Point point );

    Board getBoard();

    void onUIPutFinished();
}
