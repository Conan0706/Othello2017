package com.hatenablog.satuya.othello2017.di.module;

import com.hatenablog.satuya.othello2017.application.Othello2017;
import com.hatenablog.satuya.othello2017.model.othello2.PlayerFactory;
import com.hatenablog.satuya.othello2017.model.engine.Board;
import com.hatenablog.satuya.othello2017.model.engine.BoardImpl;
import com.hatenablog.satuya.othello2017.model.othello2.manager.BoardManager;
import com.hatenablog.satuya.othello2017.model.othello2.manager.BoardManagerImpl;
import com.hatenablog.satuya.othello2017.model.othello2.PlayerFactoryHM;
import com.hatenablog.satuya.othello2017.model.othello2.PutNotifier;
import com.hatenablog.satuya.othello2017.model.othello2.player.UIPlayer;
import com.hatenablog.satuya.othello2017.model.othello2.usecase.PutUseCase;
import com.hatenablog.satuya.othello2017.model.othello2.usecase.PutUseCaseImpl;
import com.hatenablog.satuya.othello2017.model.othello2.type.PlayerType;
import com.hatenablog.satuya.othello2017.model.othello2.player.Player;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shusei on 2017/04/27.
 */

@Module
public class DomainModule2 {

    private Othello2017 app = null;

    public DomainModule2( Othello2017 app ) {

        this.app = app;
    }

    @Provides
    @Singleton
    public PutNotifier providePutNotifier( PutUseCase putUseCase ) {

        return (PutNotifier) putUseCase;
    }

    @Provides
    @Singleton
    public PlayerFactory providePlayerFactory() {

        if ( this.app.getBlackPlayerType() == PlayerType.HUMAN
            && this.app.getWhitePlayerType() == PlayerType.HUMAN ) {
            return new PlayerFactoryHM();
        } else {
            return null; //TODO 未実装
       }
    }

    @Provides
    @Singleton
    @Named( "blackPlayer" )
    public Player provideBlackPlayer( PlayerFactory playerFactory ) {

        return playerFactory.getBlackPlayer();
    }

    @Provides
    @Singleton
    @Named( "whitePlayer" )
    public Player provideWhitePlayer( PlayerFactory playerFactory ) {

        return playerFactory.getWhitePlayer();
    }

    @Provides
    @Singleton
    public Board provideBoard() {

        return new BoardImpl();
    }

    @Provides
    @Singleton
    public  BoardManager provideBoardManager( Board board,
                                              @Named( "blackPlayer" ) Player blackPlayer,
                                              @Named( "whitePlayer" ) Player whitePlayer ) {

        return new BoardManagerImpl( board, app.getGameMode(), blackPlayer, whitePlayer );
    }

    @Provides
    @Singleton
    public PutUseCase providePutUseCase( BoardManager boardManager,
                                         @Named( "blackPlayer" ) Player blackPlayer,
                                         @Named( "whitePlayer" ) Player whitePlayer ) {

        PutUseCaseImpl putUseCase = new PutUseCaseImpl( boardManager );
        if ( blackPlayer instanceof UIPlayer ) {
            UIPlayer player = (UIPlayer) blackPlayer;
            player.setPutNotifier( putUseCase );
        }
        if ( whitePlayer instanceof UIPlayer ) {
            UIPlayer player = (UIPlayer) whitePlayer;
            player.setPutNotifier( putUseCase );
        }
        return putUseCase;
    }
}
