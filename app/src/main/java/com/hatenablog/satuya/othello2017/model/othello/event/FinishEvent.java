package com.hatenablog.satuya.othello2017.model.othello.event;

import com.hatenablog.satuya.othello2017.model.othello.entity.Color;

/**
 * Created by Shusei on 2017/03/15.
 */

public interface FinishEvent {

    Color getWinnerColor(); //引き分けは2

    Color getLoserColor(); //引き分けは2

    int getScore(); //勝者のスコア(にしたい)
}
