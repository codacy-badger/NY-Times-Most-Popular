package com.example.nytime.articles.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.nytime.articles.data.model.Article;
import com.example.nytime.articles.domain.ArticlesUseCase;

import java.util.List;

public class ArticlesViewModel extends ViewModel {

    private ArticlesUseCase articlesUseCase;


    public ArticlesViewModel(ArticlesUseCase articlesUseCase){
        this.articlesUseCase = articlesUseCase;
    }

    public LiveData<List<Article>> loadArticles(){
        return articlesUseCase.getArticles();
    }

}
