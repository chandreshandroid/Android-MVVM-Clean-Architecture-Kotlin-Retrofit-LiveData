package com.example.mvvm_kotlin_retrofit_livedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.adapter.CountryAdapter
import com.example.mvvm_kotlin_retrofit_livedata.model.Country
import com.example.mvvm_kotlin_retrofit_livedata.viewModel.CountryListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var adapter:CountryAdapter?=null
    var countryList: ArrayList<Country?> = ArrayList()
    var countryViewModel:CountryListViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()

        getCountry()
    }

    /**
     * initialization of views and others
     *
     * @param @null
     */
    private fun initialization() {

        // use a linear layout manager

        recycleView.setLayoutManager(LinearLayoutManager(this))

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recycleView.setHasFixedSize(true)

        // adapter
        adapter = CountryAdapter(this@MainActivity, countryList)
        recycleView.setAdapter(adapter)

        // View Model
        countryViewModel = ViewModelProviders.of(this).get(CountryListViewModel::class.java)
    }

    /**
     * get Country List  from news api
     *
     * @param @null
     */
    private fun getCountry() {
        countryViewModel?.getCountryResponseLiveData()?.observe(this, Observer {
            if(it!=null)
            {
                countryList.addAll(it[0].data)
                adapter?.notifyDataSetChanged()
            }

        })
    }
}