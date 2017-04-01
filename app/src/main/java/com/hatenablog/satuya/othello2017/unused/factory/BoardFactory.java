package com.hatenablog.satuya.othello2017.unused.factory;

import com.hatenablog.satuya.othello2017.domain2.othello.engine.Board;
import com.hatenablog.satuya.othello2017.domain2.othello.engine.BoardImpl;

/**
 * Created by Shusei on 2017/03/15.
 */

public class BoardFactory {

    private Board board = null;

    public Board getBoard() {
        if ( this.board == null ) {
            this.board = new BoardImpl();
        }
        return this.board;
    }
}
