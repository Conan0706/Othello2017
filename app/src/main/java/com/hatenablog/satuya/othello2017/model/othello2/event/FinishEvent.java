package com.hatenablog.satuya.othello2017.model.othello2.event;

import com.hatenablog.satuya.othello2017.model.othello.entity.Color;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface FinishEvent {

    Player getWinner();

    Player getLoser();

    int getScore( Player player ); //勝者のスコア
}
