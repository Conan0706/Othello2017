package com.hatenablog.satuya.othello2017.model.othello2;

import com.hatenablog.satuya.othello2017.model.othello2.type.Color;
import com.hatenablog.satuya.othello2017.model.othello2.type.PlayerType;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;
import com.hatenablog.satuya.othello2017.model.othello2.player.UIPlayerImpl;
import com.hatenablog.satuya.othello2017.model.othello2.value_object.PlayerDataImpl;

/**
 * Created by Shusei on 2017/04/28.
 */

public class PlayerFactoryHM extends PlayerFactory {

    private Player blackPlayer = null;
    private Player whitePlayer = null;

    public PlayerFactoryHM() {

        blackPlayer =
                new UIPlayerImpl( new PlayerDataImpl( PlayerType.HUMAN, Color.BLACK ) );

        whitePlayer =
                new UIPlayerImpl( new PlayerDataImpl( PlayerType.HUMAN, Color.WHITE ) );
    }

    @Override
    public Player getBlackPlayer() {
        return this.blackPlayer;
    }

    @Override
    public Player getWhitePlayer() {
        return this.whitePlayer;
    }
}
