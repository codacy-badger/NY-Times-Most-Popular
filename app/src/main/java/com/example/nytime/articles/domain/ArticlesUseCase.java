package com.example.nytime.articles.domain;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.nytime.BuildConfig;
import com.example.nytime.application.Constants;
import com.example.nytime.application.EspressoIdlingResource;
import com.example.nytime.articles.data.model.Article;
import com.example.nytime.articles.data.model.ArticlesResponse;
import com.example.nytime.articles.data.services.ArticlesService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ArticlesUseCase {

    ArticlesService articlesService;

    @Inject
    public ArticlesUseCase(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    public LiveData<List<Article>> getArticles() {
        final MutableLiveData<List<Article>> data = new MutableLiveData<>();

        EspressoIdlingResource.increment();

        Observable<ArticlesResponse> articlesResponseObservable = articlesService.getArticles(Constants.API_KEY);
        articlesResponseObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticlesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArticlesResponse articlesResponse) {
                        data.postValue(articlesResponse.getArticles());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("error" , e.getMessage());
                        EspressoIdlingResource.decrement();


                    }

                    @Override
                    public void onComplete() {

                        EspressoIdlingResource.decrement();

                    }
                });

        return data;
    }
}
