package com.hatenablog.satuya.othello2017.model.othello2.player;

import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.other.PlayerType;

/**
 * Created by Shusei on 2017/04/22.
 */

public interface PlayerData {

    PlayerType getPlayerType();
    Color getColor();
}
