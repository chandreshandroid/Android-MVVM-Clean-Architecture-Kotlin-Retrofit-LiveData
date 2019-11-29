package com.example.mvvm_kotlin_retrofit_livedata.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_kotlin_retrofit_livedata.api.RestCallback
import com.example.mvvm_kotlin_retrofit_livedata.api.RestClient
import com.example.mvvm_kotlin_retrofit_livedata.application.MyApplication
import com.example.mvvm_kotlin_retrofit_livedata.listener.ResponseListener

import com.example.mvvm_kotlin_retrofit_livedata.model.MovieList
import com.squareup.okhttp.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class MovieListApi() {




  suspend    fun getMovieList():MovieList? {





            return RestClient.get()!!.moverListOmDb("movie", "671de40e", "inception")


     /* try {
          if (retrivedTodo!=null) {
              data.postValue(retrivedTodo)
          } else {
              data.postValue(null)

          }
      } catch (e: Exception) {
          e.printStackTrace()
          data.postValue(null)
      }
*/
      /*  var call = RestClient.get()!!.moverListOmDb("movie","671de40e","inception")
        call.enqueue(object : RestCallback<MovieList>(MyApplication.instance) {
            override fun success(response: retrofit2.Response<MovieList>) {

                data.postValue( response.body())

            }

            override fun failure() {
                data.postValue(  null)
            }

        })
*/



       // return data
    }

}