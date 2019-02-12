package com.example.nytime.articles.dagger;


import com.example.nytime.articles.view.master.ArticlesFragment;
import com.example.nytime.dagger.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    @Provides
    @PerActivity
    ArticlesFragment provideArticleFragment() {
        return new ArticlesFragment();
    }
}
