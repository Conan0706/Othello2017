package com.hatenablog.satuya.othello2017.domain.othello.player;

import com.hatenablog.satuya.othello2017.domain.othello.BoardManager;

/**
 * Created by Shusei on 2017/03/16.
 */

public class PlayerGroup {

    private Player blackPlayer = null;
    private Player whitePlayer = null;

    public PlayerGroup( Player blackPlayer, Player whitePlayer ) {

        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    public Player getBlackPlayer() {

        return this.blackPlayer;
    }

    public Player getWhitePlayer() {

        return this.whitePlayer;
    }

    public void setManager( BoardManager manager ) {

        this.blackPlayer.setManager( manager );
        this.whitePlayer.setManager( manager );
    }
}
