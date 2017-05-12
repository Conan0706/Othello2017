package com.hatenablog.satuya.othello2017.model.othello2.player;

import com.hatenablog.satuya.othello2017.model.othello2.value_object.PlayerData;

/**
 * Created by Shusei on 2017/04/28.
 */

public class AI implements Player {

    private PlayerData playerData = null;

    public AI( PlayerData playerData ) {

        this.playerData = playerData;
    }

    @Override
    public void onTurn() {

    }

    @Override
    public PlayerData getPlayerData() {
        return null;
    }
}
