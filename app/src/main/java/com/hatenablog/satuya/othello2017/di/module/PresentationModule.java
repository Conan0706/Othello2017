package com.hatenablog.satuya.othello2017.di.module;

import com.hatenablog.satuya.othello2017.model.othello2.usecase.PutUseCase;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenter;
import com.hatenablog.satuya.othello2017.presentation.presenter.GamePresenterImpl2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shusei on 2017/03/15.
 */

@Module
public class PresentationModule {

    @Provides
    public GamePresenter provideBoardPresenter( PutUseCase putUseCase ) {

        return new GamePresenterImpl2( putUseCase );
    }
}
