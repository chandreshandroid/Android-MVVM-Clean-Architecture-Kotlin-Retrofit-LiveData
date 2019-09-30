package com.example.mvvm_kotlin_retrofit_livedata.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_kotlin_retrofit_livedata.model.CountryList
import com.example.mvvm_kotlin_retrofit_livedata.repository.CountryListApi

class CountryListViewModel():ViewModel() {




    fun getCountryResponseLiveData(): LiveData<List<CountryList>> {

        return CountryListApi().getCountryList()
    }
}