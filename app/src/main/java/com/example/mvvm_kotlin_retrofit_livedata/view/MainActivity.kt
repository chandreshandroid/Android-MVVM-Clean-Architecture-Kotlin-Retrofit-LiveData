package com.example.mvvm_kotlin_retrofit_livedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.adapter.MovieAdapter
import com.example.mvvm_kotlin_retrofit_livedata.customView.MyRecycleView
import com.example.mvvm_kotlin_retrofit_livedata.listener.MovieItemClicklistener
import com.example.mvvm_kotlin_retrofit_livedata.model.Movie
import com.example.mvvm_kotlin_retrofit_livedata.viewModel.MovieListViewModel
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.error_view.*

class MainActivity : AppCompatActivity(),MovieItemClicklistener {


    var adapter:MovieAdapter?=null
    var movieList: ArrayList<Movie?> = ArrayList()
    var movieListViewModel:MovieListViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()

        getMovie()

        btnRetry.setOnClickListener {
            getMovie()
        }
    }



    private fun initialization() {


        recycleView.layoutManager = LinearLayoutManager(this)


        recycleView.setHasFixedSize(true)

        // adapter
        adapter = MovieAdapter( movieList,this)
        recycleView.adapter = adapter

        recycleView.loadingStateView=progressbar
        recycleView.errorStateView=errorView
        // View Model
        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
    }

    /**
     * get Movie List from api
     *
     * @param @null
     */
    private fun getMovie() {


        recycleView.stateViewState=MyRecycleView.RecyclerViewStateEnum.LOADING


        movieListViewModel?.getMovieListResponseLiveData()?.observe(this, Observer {
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

    override fun onMovieItemClick(movie: Movie) {
        Toast.makeText(this,movie.title.toString(),Toast.LENGTH_LONG).show()
    }
}