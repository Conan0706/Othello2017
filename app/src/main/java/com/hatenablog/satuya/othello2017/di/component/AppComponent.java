package com.hatenablog.satuya.othello2017.di.component;

import com.hatenablog.satuya.othello2017.di.module.AppModule;
import com.hatenablog.satuya.othello2017.di.module.DomainModule2;
import com.hatenablog.satuya.othello2017.di.module.PresentationModule;
import com.hatenablog.satuya.othello2017.di.module.DomainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Shusei on 2017/03/15.
 */

@Singleton
@Component( modules = {
        AppModule.class,
        DomainModule2.class,
        PresentationModule.class,
}
)

public interface AppComponent extends PresentationComponent {
}
