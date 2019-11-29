package com.example.mvvm_kotlin_retrofit_livedata.listener

import androidx.lifecycle.LiveData
import com.example.mvvm_kotlin_retrofit_livedata.model.MovieList

interface ResponseListener  {
    fun onShowProgress()
    fun onFailure()
    fun onSuccess(response: MovieList)
}
