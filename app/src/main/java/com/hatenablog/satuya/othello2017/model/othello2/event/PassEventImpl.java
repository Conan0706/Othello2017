package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello2.BoardValueGroup;
import com.hatenablog.satuya.othello2017.model.othello2.other.PlayerType;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;
import com.hatenablog.satuya.othello2017.model.othello2.player.PlayerData;

/**
 * Created by Shusei on 2017/03/15.
 */

public class PassEventImpl implements PassEvent {

    private BoardValueGroup boardValueGroup = null;

    private PlayerData playerData = null;

    public PassEventImpl( BoardValueGroup group, PlayerData data ) {

        this.boardValueGroup = group;
        this.playerData = data;
    }

    @Override
    public PlayerData getPassPlayer() {
        return playerData;
    }

    @Override
    public BoardValueGroup getBoardValueGroup() {
        return boardValueGroup;
    }
}
