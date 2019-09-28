package com.example.mvvm_kotlin_retrofit_livedata.api


import android.provider.Settings
import com.example.mvvm_kotlin_retrofit_livedata.BuildConfig

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {


    companion object
    {
        val apiType = "Android"
        val apiVersion = "1.0"

        // Base server url
        var url = "http://betaapplication.com/medical/backend/web/index.php/v1/"


        internal var REST_CLIENT: RestApi? = null


        private var restAdapter: Retrofit? = null


        init {
            setupRestClient()

        }

        fun setOkHttpClientBuilder(): OkHttpClient.Builder {
            val loggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                // development build
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
                // production build
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
            }
            val builder = OkHttpClient.Builder()
            builder.addInterceptor(loggingInterceptor)
            builder.connectTimeout(300, TimeUnit.SECONDS)
            builder.readTimeout(80, TimeUnit.SECONDS)
            builder.writeTimeout(90, TimeUnit.SECONDS)
            return builder
        }

        fun setupRestClient() {

            val gson = GsonBuilder().setLenient().create()
            restAdapter = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(
                    setOkHttpClientBuilder()
                        .build()
                )
                .build()
        }


        fun get(): RestApi? {
            if (REST_CLIENT == null) {
                REST_CLIENT = restAdapter!!.create(
                    RestApi::class.java
                )

            }
            return REST_CLIENT
        }


    }
}


