package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.othello2.BoardValueGroup;
import com.hatenablog.satuya.othello2017.model.othello2.player.PlayerData;

/**
 * Created by Shusei on 2017/04/22.
 */

public class UndoEventImpl implements UndoEvent {

    private BoardValueGroup boardValueGroup = null;
    private PlayerData playerData = null;

    public UndoEventImpl( BoardValueGroup boardValueGroup, PlayerData playerData ) {

        this.boardValueGroup = boardValueGroup;
        this.playerData = playerData;
    }

    @Override
    public BoardValueGroup getBoardValueGroup() {
        return this.boardValueGroup;
    }

    @Override
    public PlayerData getUndoPlayer() {
        return this.playerData;
    }
}
