package com.example.mvvm_kotlin_retrofit_livedata.api



import com.example.mvvm_kotlin_retrofit_livedata.model.CountryList
import retrofit2.Call
import retrofit2.http.*


public interface RestApi {



    @FormUrlEncoded
    @POST("country/get-country-list")
    fun countryList(@Field("json") json: String): Call<List<CountryList>>



}
