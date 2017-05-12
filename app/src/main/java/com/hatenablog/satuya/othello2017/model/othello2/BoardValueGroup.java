package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.othello2.type.Color;
import com.hatenablog.satuya.othello2017.model.othello2.type.GameMode;
import com.hatenablog.satuya.othello2017.model.othello2.type.PlayerType;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Point;

/**
 * Created by Shusei on 2017/04/22.
 */

public interface BoardValueGroup {

    PlayerType getCurrentPlayerType();
    PlayerType getPlayerType( Color color );
    Color getCurrentColorType();
    Color getColorType( Point point );
    GameMode getCurrentMode();
    int getTurns();
}
