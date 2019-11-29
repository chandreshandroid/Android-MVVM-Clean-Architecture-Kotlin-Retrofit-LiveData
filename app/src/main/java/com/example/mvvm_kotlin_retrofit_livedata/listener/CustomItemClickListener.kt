package com.example.mvvm_kotlin_retrofit_livedata.listener

import com.example.mvvm_kotlin_retrofit_livedata.model.Movie

interface CustomItemClickListener {
    fun onMovieItemClick(movie:Movie)
}