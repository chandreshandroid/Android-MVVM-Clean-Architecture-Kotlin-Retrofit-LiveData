package com.example.mvvm_kotlin_retrofit_livedata.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.adapter.MovieAdapter
import com.example.mvvm_kotlin_retrofit_livedata.customView.MyRecycleView
import com.example.mvvm_kotlin_retrofit_livedata.databinding.ActivityMainBinding
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
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
         binding=DataBindingUtil.setContentView(this,R.layout.activity_main)


        initialization()

        getMovie()

        binding.errorView.btnRetry.setOnClickListener {
            getMovie()
        }
    }



    private fun initialization() {


        binding.recycleView.layoutManager = LinearLayoutManager(this)


        binding.recycleView.setHasFixedSize(true)

        // adapter
        adapter = MovieAdapter( movieList,this)
        binding.recycleView.adapter = adapter

        binding.recycleView.loadingStateView=progressbar
        binding.recycleView.errorStateView=errorView
        // View Model
        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)

    }

    /**
     * get Movie List from api
     *
     * @param @null
     */
    private fun getMovie() {


        binding.recycleView.stateViewState=MyRecycleView.RecyclerViewStateEnum.LOADING


        movieListViewModel?.getMovieListResponseLiveData()?.observe(this, Observer {
            if(it!=null)
            {
                movieList.addAll(it.search)
                adapter?.notifyDataSetChanged()
            }
            else
            {
                binding.recycleView.stateViewState=MyRecycleView.RecyclerViewStateEnum.ERROR
            }

        })
    }

    override fun onMovieItemClick(movie: Movie) {
        Toast.makeText(this,movie.title.toString(),Toast.LENGTH_LONG).show()
    }
}