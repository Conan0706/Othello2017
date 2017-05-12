package com.hatenablog.satuya.othello2017.application;

import android.app.Application;

import com.hatenablog.satuya.othello2017.di.component.AppComponent;
import com.hatenablog.satuya.othello2017.di.component.DaggerAppComponent;
import com.hatenablog.satuya.othello2017.di.module.AppModule;
import com.hatenablog.satuya.othello2017.di.module.DomainModule2;
import com.hatenablog.satuya.othello2017.di.module.PresentationModule;
import com.hatenablog.satuya.othello2017.model.othello2.type.GameMode;
import com.hatenablog.satuya.othello2017.model.othello2.type.PlayerType;

/**
 * Created by Shusei on 2017/03/15.
 */

public class Othello2017 extends Application {

    private GameMode gameMode = GameMode.HUMAN_MODE; //デフォルト
    private PlayerType blackPlayerType = PlayerType.HUMAN; //デフォルト
    private PlayerType whitePlayerType = PlayerType.HUMAN; //デフォルト

    private AppComponent component = null;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule( new AppModule( this ) )
                .presentationModule( new PresentationModule() )
                .domainModule2( new DomainModule2( this ) )
                .build();
    }

    public AppComponent getAppComponent() {

        return this.component;
    }

    public void setGameMode( GameMode mode ) {

        this.gameMode = mode;
    }

    public void setBlackPlayerType( PlayerType type ) {

        this.blackPlayerType = type;
    }

    public void setWhitePlayerType( PlayerType type ) {

        this.whitePlayerType = type;
    }

    public GameMode getGameMode() {

        return this.gameMode;
    }

    public PlayerType getBlackPlayerType() {

        return this.blackPlayerType;
    }

    public PlayerType getWhitePlayerType() {

        return this.whitePlayerType;
    }
}
