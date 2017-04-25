package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.othello2.other.EventType;
import com.hatenablog.satuya.othello2017.model.othello2.other.GameMode;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;
import com.hatenablog.satuya.othello2017.model.othello2.player.PlayerData;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.Move;

/**
 * Created by Shusei on 2017/04/04.
 */

public interface BoardManager {

    void init( GameMode mode, Player blackPlayer, Player whitePlayer );

    void addObserver( BoardListener observer );
    void deleteObserver( BoardListener observer );

    boolean put( Move move );
    boolean undo( PlayerData playerData );

    boolean check( Move move );

    void igniteEvent( EventType type );
}
