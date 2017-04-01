package com.hatenablog.satuya.othello2017.domain2.othello;

import com.hatenablog.satuya.othello2017.domain2.othello.engine.Board;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Point;
import com.hatenablog.satuya.othello2017.domain2.othello.observer.BoardObserver;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface BoardManager {

    void initBoard();
    void addObserver( BoardObserver observer );
    boolean put( Point point );
    Board getBoard();
}
