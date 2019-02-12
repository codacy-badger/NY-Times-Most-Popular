package com.example.nytime.articles.dagger;


import com.example.nytime.MainActivity;
import com.example.nytime.dagger.scopes.PerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilder {



    @PerActivity
    @ContributesAndroidInjector(modules = {ApiModule.class ,ActivityModule.class, FragmentBuilder.class})
    MainActivity getMainActivity();
}



