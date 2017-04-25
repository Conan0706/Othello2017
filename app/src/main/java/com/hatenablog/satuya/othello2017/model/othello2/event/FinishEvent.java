package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello2.other.Color;
import com.hatenablog.satuya.othello2017.model.othello2.other.PlayerType;
import com.hatenablog.satuya.othello2017.model.othello2.player.PlayerData;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface FinishEvent extends Event {

    PlayerData getWinner();

    PlayerData getLoser();

    int getScore( Color color );
}
