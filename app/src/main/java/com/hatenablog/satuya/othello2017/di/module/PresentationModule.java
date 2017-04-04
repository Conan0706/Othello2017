package com.hatenablog.satuya.othello2017.di.module;

import com.hatenablog.satuya.othello2017.model.othello.BoardManager;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenterImpl;
import com.hatenablog.satuya.othello2017.usecase.PosInputUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shusei on 2017/03/15.
 */

@Module
public class PresentationModule {

    @Provides
    public GamePresenter provideBoardPresenter( PosInputUseCase useCase, BoardManager boardManager ) {

        return new GamePresenterImpl( useCase, boardManager );
    }
}
