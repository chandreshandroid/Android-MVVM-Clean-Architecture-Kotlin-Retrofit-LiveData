package com.example.mvvm_kotlin_retrofit_livedata.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_kotlin_retrofit_livedata.api.RestCallback
import com.example.mvvm_kotlin_retrofit_livedata.api.RestClient
import com.example.mvvm_kotlin_retrofit_livedata.application.MyApplication
import com.example.mvvm_kotlin_retrofit_livedata.model.CountryList
import com.squareup.okhttp.Response
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class CountryListApi() {


     fun getCountryList(): LiveData<List<CountryList>> {
        val data = MutableLiveData<List<CountryList>>()

        val jsonArray = JSONArray()
        val jsonObject = JSONObject()
        try {
            jsonObject.put("loginuserID", "0")
            jsonObject.put("languageID", "1")
            jsonObject.put("apiType", RestClient.apiType)
            jsonObject.put("apiVersion", RestClient.apiVersion)

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        jsonArray.put(jsonObject)


            var call = RestClient.get()!!.countryList(jsonArray.toString())
            call.enqueue(object : RestCallback<List<CountryList>>(MyApplication.instance) {
                override fun Success(response: retrofit2.Response<List<CountryList>>) {



                    data.value = response.body()

                }

                override fun failure() {
                    data.value = null
                }

            })






        return data
    }

}