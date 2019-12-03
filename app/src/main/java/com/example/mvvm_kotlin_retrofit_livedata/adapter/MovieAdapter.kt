package com.example.mvvm_kotlin_retrofit_livedata.adapter


import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_retrofit_livedata.BR
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.databinding.ItemMovie1Binding
import com.example.mvvm_kotlin_retrofit_livedata.listener.MovieItemClicklistener
import com.example.mvvm_kotlin_retrofit_livedata.model.Movie





class MovieAdapter(


    val movieList: ArrayList<Movie?>,
    var movieItemClicklistener: MovieItemClicklistener

) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {


        var binding = DataBindingUtil.inflate<ItemMovie1Binding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie1,
            parent,
            false
        )


        return MovieViewHolder(binding)

    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.bind(movieList[position]!!)

    }

    override fun getItemCount(): Int {

        return movieList.size
    }

    inner class MovieViewHolder(var itemMovie1Binding: ItemMovie1Binding) :
        RecyclerView.ViewHolder(itemMovie1Binding.root) {

        fun bind(movie: Movie) = with(itemMovie1Binding)
        {
            setVariable(BR.movie, movie)
            executePendingBindings()
            movieClick = movieItemClicklistener
        }


    }


}