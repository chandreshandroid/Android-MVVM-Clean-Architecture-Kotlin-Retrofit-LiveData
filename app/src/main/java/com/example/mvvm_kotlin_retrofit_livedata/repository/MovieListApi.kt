package com.example.mvvm_kotlin_retrofit_livedata.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_kotlin_retrofit_livedata.api.RestCallback
import com.example.mvvm_kotlin_retrofit_livedata.api.RestClient
import com.example.mvvm_kotlin_retrofit_livedata.application.MyApplication

import com.example.mvvm_kotlin_retrofit_livedata.model.MovieList
import com.squareup.okhttp.Response
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class MovieListApi() {


     fun getMovieList(): LiveData<MovieList> {
        val data = MutableLiveData<MovieList>()




            var call = RestClient.get()!!.moverListOmDb("movie","671de40e","inception")
            call.enqueue(object : RestCallback<MovieList>(MyApplication.instance) {
                override fun Success(response: retrofit2.Response<MovieList>) {



                    data.value = response.body()

                }

                override fun failure() {
                    data.value = null
                }

            })






        return data
    }

}