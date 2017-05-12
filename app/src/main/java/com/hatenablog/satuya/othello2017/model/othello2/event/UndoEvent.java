package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello2.value_object.PlayerData;

/**
 * Created by Shusei on 2017/03/21.
 */

public interface UndoEvent extends Event {

    PlayerData getUndoPlayer();
}
