package com.example.nytime.application;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

//import com.example.nytime.dagger.component.DaggerAppComponent;

import com.example.nytime.dagger.component.DaggerAppComponent;
import com.facebook.drawee.backends.pipeline.Fresco;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class ArticlesApplication extends Application implements HasActivityInjector , HasSupportFragmentInjector {


    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .application(this)
                .networkModule(Constants.URL)
                .build()
                .inject(this);

        Fresco.initialize(this);
    }




    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
