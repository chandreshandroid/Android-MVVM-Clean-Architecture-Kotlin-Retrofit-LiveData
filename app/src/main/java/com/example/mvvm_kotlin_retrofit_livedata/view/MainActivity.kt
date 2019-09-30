package com.example.mvvm_kotlin_retrofit_livedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.adapter.MovieAdapter
import com.example.mvvm_kotlin_retrofit_livedata.customView.MyRecycleView
import com.example.mvvm_kotlin_retrofit_livedata.model.Movie
import com.example.mvvm_kotlin_retrofit_livedata.viewModel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.error_view.*

class MainActivity : AppCompatActivity() {


    var adapter:MovieAdapter?=null
    var movieList: ArrayList<Movie?> = ArrayList()
    var moviewListViewModel:MovieListViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()

        getMovie()

        btnRetry.setOnClickListener {
            getMovie()
        }
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
        adapter = MovieAdapter(this@MainActivity, movieList)
        recycleView.setAdapter(adapter)

        recycleView.loadingStateView=progressbar
        recycleView.errorStateView=errorView
        // View Model
        moviewListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
    }

    /**
     * get Movie List from api
     *
     * @param @null
     */
    private fun getMovie() {


        recycleView.stateViewState=MyRecycleView.RecyclerViewStateEnum.LOADING


        moviewListViewModel?.getMovieListResponseLiveData()?.observe(this, Observer {
            if(it!=null)
            {
                movieList.addAll(it.search)
                adapter?.notifyDataSetChanged()
            }
            else
            {
                recycleView.stateViewState=MyRecycleView.RecyclerViewStateEnum.ERROR
            }

        })
    }
}