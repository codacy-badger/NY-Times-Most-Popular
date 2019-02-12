package com.example.nytime.articles.dagger;

import com.example.nytime.articles.view.master.ArticlesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuilder {

    @ContributesAndroidInjector
    ArticlesFragment getArticlesFragment();
}
