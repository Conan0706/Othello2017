package com.hatenablog.satuya.othello2017.di.module;

import com.hatenablog.satuya.othello2017.application.Othello2017;
import com.hatenablog.satuya.othello2017.domain2.othello.BoardManagerImpl;
import com.hatenablog.satuya.othello2017.domain2.othello.BoardManager;
import com.hatenablog.satuya.othello2017.domain2.othello.algorithm.AI;
import com.hatenablog.satuya.othello2017.domain2.othello.algorithm.TestAI;
import com.hatenablog.satuya.othello2017.domain2.othello.engine.Board;
import com.hatenablog.satuya.othello2017.domain2.othello.engine.BoardImpl;
import com.hatenablog.satuya.othello2017.domain2.othello.entity.Color;
import com.hatenablog.satuya.othello2017.domain2.othello.player.PlayerGroup;
import com.hatenablog.satuya.othello2017.domain2.othello.player.PlayerType;
import com.hatenablog.satuya.othello2017.presentation.UIPlayer;
import com.hatenablog.satuya.othello2017.usecase.PosInputUseCase;
import com.hatenablog.satuya.othello2017.usecase.PosInputUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shusei on 2017/03/15.
 */

@Module
public class DomainModule {

    private PosInputUseCase useCase = null;
    private PlayerGroup playerGroup = null;
    private Board board = null;
    private BoardManager manager = null;
    private AI ai = null;

    private Othello2017 othello2017 = null;

    public DomainModule( Othello2017 othello2017 ) {

        this.othello2017 = othello2017;
    }

    @Provides
    public PosInputUseCase providePosInputUseCase( PlayerGroup group ) {

        if ( this.useCase == null ) {
            this.useCase = new PosInputUseCaseImpl( group );
        }

        return this.useCase;
    }

    @Provides
    public Board provideBoard() {

        if ( this.board == null ) {
            this.board = new BoardImpl();
        }

        return this.board;
    }

    @Provides
    public BoardManager provideBoardManager( Board board, PlayerGroup group ) {

        if ( this.manager == null ) {
            this.manager = new BoardManagerImpl( board, group );
        }

        return this.manager;
    }

    @Provides
    public PlayerGroup providePlayerGroup( AI ai ) {

        if ( this.playerGroup == null ) {
            this.playerGroup = createPG( ai );
        }

        return this.playerGroup;
    }

    @Provides
    public AI provideAI() {

        if ( this.ai == null ) {
            this.ai = new TestAI();
        }

        return this.ai;
    }

    private PlayerGroup createPG( AI ai ) {

        PlayerGroup group = null;

        PlayerType blackType = othello2017.getBlackPlayerType();
        PlayerType whiteType = othello2017.getWhitePlayerType();

        UIPlayer uiPlayer1 = new UIPlayer( Color.BLACK );
        UIPlayer uiPlayer2 = new UIPlayer( Color.WHITE );

        if ( blackType == PlayerType.HUMAN ) {

            switch ( whiteType ) {
                case HUMAN:
                    group = new PlayerGroup( uiPlayer1, uiPlayer2 );
                    break;
                case COMPUTER:
                    group = new PlayerGroup( uiPlayer1, ai );
                    uiPlayer2 = null;
                    break;
            }
        } else if ( blackType == PlayerType.COMPUTER ) {

            group = new PlayerGroup( ai, uiPlayer2 );
        }

        return group;
    }
}
