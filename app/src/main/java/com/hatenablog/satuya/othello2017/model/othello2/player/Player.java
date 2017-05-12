package com.hatenablog.satuya.othello2017.model.othello2.player;

import com.hatenablog.satuya.othello2017.model.othello2.value_object.PlayerData;

/**
 * Created by Shusei on 2017/04/05.
 */

public interface Player {

    void onTurn();
    PlayerData getPlayerData();
}