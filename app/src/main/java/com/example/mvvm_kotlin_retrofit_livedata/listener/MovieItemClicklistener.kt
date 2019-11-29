package com.example.mvvm_kotlin_retrofit_livedata.listener

import com.example.mvvm_kotlin_retrofit_livedata.model.Movie

interface MovieItemClicklistener {

    fun onMovieItemClick(movie: Movie)
}