package com.example.mvvm_kotlin_retrofit_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.example.mvvm_kotlin_retrofit_livedata.model.MovieList
import com.example.mvvm_kotlin_retrofit_livedata.repository.MovieListApi

class MovieListViewModel():ViewModel() {




    fun getMovieListResponseLiveData(): LiveData<MovieList> {

        return MovieListApi().getMovieList()
    }
}