package com.example.mvvm_kotlin_retrofit_livedata.application



import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco


class MyApplication : Application() {


    companion object {
        lateinit var instance: MyApplication





    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Fresco.initialize(this)



    }





}