package com.hatenablog.satuya.othello2017.model.othello2.player;

import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.other.PlayerType;

/**
 * Created by Shusei on 2017/04/22.
 */

public class PlayerDataImpl implements PlayerData {

    private PlayerType playerType = null;
    private Color color = null;

    public PlayerDataImpl( PlayerType playerType, Color color ) {

        this.playerType = playerType;
        this.color = color;
    }

    @Override
    public PlayerType getPlayerType() {
        return playerType;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
