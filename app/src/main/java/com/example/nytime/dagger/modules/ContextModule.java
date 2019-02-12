package com.example.nytime.dagger.modules;

import android.app.Application;
import android.content.Context;

import com.example.nytime.dagger.qualifier.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ashaker on 12/4/2017.
 */

@Module
public class ContextModule {



    /*@Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }*/

    @Provides
    @Singleton
    Context provideApplication(Application application) {
        return application;
    }




}