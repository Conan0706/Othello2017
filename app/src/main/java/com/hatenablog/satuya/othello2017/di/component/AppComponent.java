package com.hatenablog.satuya.othello2017.di.component;

import com.hatenablog.satuya.othello2017.di.module.AppModule;
import com.hatenablog.satuya.othello2017.di.module.PresentationModule;
import com.hatenablog.satuya.othello2017.di.module.DomainModule;

import dagger.Component;

/**
 * Created by Shusei on 2017/03/15.
 */

@Component( modules = {
        AppModule.class,
        DomainModule.class,
        PresentationModule.class,
}
)

public interface AppComponent extends PresentationComponent {
}
