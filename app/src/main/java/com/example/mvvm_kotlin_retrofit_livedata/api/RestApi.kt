package com.example.mvvm_kotlin_retrofit_livedata.api




import com.example.mvvm_kotlin_retrofit_livedata.model.MovieList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.GET




public interface RestApi {






    @GET("/")
   suspend fun moverListOmDb(@Query("t") type:String, @Query("apikey") apiKey:String, @Query("s") search:String): MovieList?

}
