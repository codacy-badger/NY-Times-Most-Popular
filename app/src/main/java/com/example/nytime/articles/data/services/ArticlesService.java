package com.example.nytime.articles.data.services;

import com.example.nytime.articles.data.model.ArticlesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticlesService {

    @GET("v2/mostviewed/all-sections/7.json")
    Observable<ArticlesResponse> getArticles(@Query("api-key") String apiKey);

}
