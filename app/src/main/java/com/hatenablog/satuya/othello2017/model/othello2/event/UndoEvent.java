package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

/**
 * Created by Shusei on 2017/03/21.
 */

public interface UndoEvent {

    Player getUndoPlayer();
}
