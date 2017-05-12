package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

/**
 * Created by Shusei on 2017/04/28.
 */

public abstract class PlayerFactory {

    abstract public Player getBlackPlayer();
    abstract public Player getWhitePlayer();
}
