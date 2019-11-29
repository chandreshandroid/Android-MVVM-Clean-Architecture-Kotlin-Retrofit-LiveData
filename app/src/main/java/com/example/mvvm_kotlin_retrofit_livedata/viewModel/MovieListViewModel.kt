package com.example.mvvm_kotlin_retrofit_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_kotlin_retrofit_livedata.listener.ResponseListener
import com.example.mvvm_kotlin_retrofit_livedata.model.Movie
import com.example.mvvm_kotlin_retrofit_livedata.model.MovieList

import com.example.mvvm_kotlin_retrofit_livedata.repository.MovieListApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MovieListViewModel() : ViewModel() {

    var responseListener: ResponseListener? = null



    fun getMovieListResponseLiveData() {
        responseListener?.onShowProgress()
        viewModelScope.launch{
            try {
                var movieList = MovieListApi().getMovieList()

                if (movieList == null) {
                    responseListener?.onFailure()

                } else {

                    responseListener?.onSuccess(movieList!!)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                responseListener?.onFailure()
            }


        }
    }
}