package com.example.mvvm_kotlin_retrofit_livedata.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.adapter.MovieAdapter
import com.example.mvvm_kotlin_retrofit_livedata.customView.MyRecycleView
import com.example.mvvm_kotlin_retrofit_livedata.databinding.ActivityMainBinding
import com.example.mvvm_kotlin_retrofit_livedata.listener.CustomItemClickListener
import com.example.mvvm_kotlin_retrofit_livedata.listener.ResponseListener
import com.example.mvvm_kotlin_retrofit_livedata.model.Movie
import com.example.mvvm_kotlin_retrofit_livedata.model.MovieList
import com.example.mvvm_kotlin_retrofit_livedata.viewModel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.error_view.view.*


class MainActivity : AppCompatActivity(),ResponseListener,CustomItemClickListener {



    var adapter:MovieAdapter?=null
    var movieList: ArrayList<Movie?> = ArrayList()
    var movieListViewModel:MovieListViewModel?=null

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initialization()

      getMovie()

        binding?.errorView?.btnRetry?.setOnClickListener {
            binding?.recycleView?.stateViewState=MyRecycleView.RecyclerViewStateEnum.LOADING
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

        binding?.recycleView?.setLayoutManager(LinearLayoutManager(this))

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        binding?.recycleView?.setHasFixedSize(true)

        // adapter
        adapter = MovieAdapter(this@MainActivity, movieList,this)
        binding?.recycleView?.setAdapter(adapter)

        binding?.recycleView?.loadingStateView=progressbar
        binding?.recycleView?.errorStateView=errorView
        // View Model
        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)

        movieListViewModel?.responseListener=this
    }

    /**
     * get Movie List from api
     *
     * @param @null
     */
    private fun getMovie() {

        movieListViewModel?.getMovieListResponseLiveData()

    }

    override fun onShowProgress() {
        recycleView.stateViewState=MyRecycleView.RecyclerViewStateEnum.LOADING

    }

    override fun onFailure() {

            recycleView.stateViewState = MyRecycleView.RecyclerViewStateEnum.ERROR


    }

    override fun onSuccess(response:MovieList) {
       /* response.observe(this, Observer {
            recycleView.stateViewState=MyRecycleView.RecyclerViewStateEnum.NORMAL
            movieList.addAll(it.search)
            adapter?.notifyDataSetChanged()
        })
*/
        movieList.addAll(response.search)
        adapter?.notifyDataSetChanged()

    }

    override fun onMovieItemClick(movie: Movie) {
        Toast.makeText(this,movie.title.toString(),Toast.LENGTH_LONG).show()
    }
}