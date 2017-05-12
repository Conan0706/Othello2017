package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.othello2.type.GameMode;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.PlayerData;

/**
 * Created by Shusei on 2017/04/27.
 */

public interface GameData {

    GameMode getGameMode();
    PlayerData getBlackPlayerData();
    PlayerData getWhitePlayerData();
}
