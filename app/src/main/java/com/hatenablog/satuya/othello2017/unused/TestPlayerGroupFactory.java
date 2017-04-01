package com.hatenablog.satuya.othello2017.unused;

import com.hatenablog.satuya.othello2017.application.Othello2017;
import com.hatenablog.satuya.othello2017.domain2.othello.BoardManager;
import com.hatenablog.satuya.othello2017.domain2.othello.algorithm.AI;
import com.hatenablog.satuya.othello2017.domain2.othello.algorithm.TestAI;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Color;
import com.hatenablog.satuya.othello2017.unused.factory.PlayerGroupFactory;
import com.hatenablog.satuya.othello2017.domain2.othello.player.PlayerGroup;
import com.hatenablog.satuya.othello2017.domain2.othello.player.PlayerType;
import com.hatenablog.satuya.othello2017.presentation.UIPlayer;

/**
 * Created by Shusei on 2017/03/19.
 */

public class TestPlayerGroupFactory implements PlayerGroupFactory {

    private Othello2017 othello2017 = null; //TODO null
//    private GamePresenterImpl boardPresenterImpl = null; //TODO null
    private BoardManager boardManager = null; //TODO null

    private PlayerGroup playerGroup = null;

    public TestPlayerGroupFactory( Othello2017 othello2017 ) {

        this.othello2017 = othello2017;
    }

    @Override
    public PlayerGroup getPlayerGroup() {

        if ( playerGroup == null ) {

            createPG();
        }

        return this.playerGroup;
    }

    private void createPG() {

        PlayerType blackType = othello2017.getBlackPlayerType();
        PlayerType whiteType = othello2017.getWhitePlayerType();

//        boardPresenterImpl.setManager( boardManager );
        AI ai = new TestAI();
        ai.setManager( boardManager );

        UIPlayer uiPlayer1 = new UIPlayer( Color.BLACK );
        UIPlayer uiPlayer2 = new UIPlayer( Color.WHITE );
        uiPlayer1.setManager( boardManager );
        uiPlayer2.setManager( boardManager );

        if ( blackType == PlayerType.HUMAN ) {

            switch ( whiteType ) {
                case HUMAN:
                    playerGroup = new PlayerGroup( uiPlayer1, uiPlayer2 );
                    break;
                case COMPUTER:
                    playerGroup = new PlayerGroup( uiPlayer1, ai );
                    uiPlayer2 = null;
                    break;
            }
        } else if ( blackType == PlayerType.COMPUTER ) {

            playerGroup = new PlayerGroup( ai, uiPlayer2 );
            uiPlayer1 = null; //TODO 不要か
        }
    }
}

