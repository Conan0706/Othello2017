package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello.entity.Point;
import com.hatenablog.satuya.othello2017.model.othello2.BoardValueGroup;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;

/**
 * Created by Shusei on 2017/03/15.
 */

public class WrongMoveEventImpl implements WrongMoveEvent {

    private BoardValueGroup boardValueGroup = null;
    private Move move = null;

    public WrongMoveEventImpl( BoardValueGroup group, Move move ) {

        this.boardValueGroup = group;
        this.move = move;
    }
    @Override
    public BoardValueGroup getBoardValueGroup() {
        return this.boardValueGroup;
    }

    @Override
    public Move getWrongMove() {
        return this.move;
    }
}
