package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello2.value_object.PlayerData;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface PassEvent extends Event {

    PlayerData getPassPlayer();
}
