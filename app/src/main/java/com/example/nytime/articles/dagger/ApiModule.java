package com.example.nytime.articles.dagger;


import com.example.nytime.articles.data.services.ArticlesService;
import com.example.nytime.dagger.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @PerActivity
    ArticlesService getService(Retrofit retrofit){
        return retrofit.create(ArticlesService.class);
    }


}
