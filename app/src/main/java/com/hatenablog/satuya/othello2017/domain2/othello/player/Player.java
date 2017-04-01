package com.hatenablog.satuya.othello2017.domain2.othello.player;

import com.hatenablog.satuya.othello2017.domain2.othello.BoardManager;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface Player { //Observerとして用いる(夜考えているので後でわからなくなる可能性あり)

    void onTurn();
    void setManager( BoardManager manager );
}
