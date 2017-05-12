package com.hatenablog.satuya.othello2017.model.othello2.value_object;

import com.hatenablog.satuya.othello2017.model.othello2.type.Color;
import com.hatenablog.satuya.othello2017.model.othello2.type.PlayerType;

/**
 * Created by Shusei on 2017/04/22.
 */

public interface PlayerData {

    PlayerType getPlayerType();
    Color getColor();
}
