package com.hatenablog.satuya.othello2017.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Shusei on 2017/03/19.
 */

@Module
public class AppModule {

    private Application application = null;

    public AppModule ( Application application ) {

        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {

        return this.application;
    }
}
