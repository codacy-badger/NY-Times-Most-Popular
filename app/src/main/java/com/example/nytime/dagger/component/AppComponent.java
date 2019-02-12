package com.example.nytime.dagger.component;

import android.app.Application;

import com.example.nytime.application.ArticlesApplication;
import com.example.nytime.articles.dagger.ActivityBuilder;
import com.example.nytime.dagger.modules.ContextModule;
import com.example.nytime.dagger.modules.NetworkModule;
import com.example.nytime.dagger.modules.PicassoModule;
import com.example.nytime.dagger.qualifier.ApplicationContext;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by ashaker on 12/19/2017.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,NetworkModule.class , ActivityBuilder.class,  PicassoModule.class , ContextModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
       @BindsInstance
       Builder application(Application application);

        @BindsInstance
        Builder networkModule(@Named("url") String url);



        AppComponent build();
    }


    void inject(ArticlesApplication app);

}