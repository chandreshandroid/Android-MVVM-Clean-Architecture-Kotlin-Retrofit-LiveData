package com.example.mvvm_kotlin_retrofit_livedata.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_retrofit_livedata.BR
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.databinding.ItemMovie1Binding
import com.example.mvvm_kotlin_retrofit_livedata.listener.MovieItemClicklistener
import com.example.mvvm_kotlin_retrofit_livedata.model.Movie
import com.facebook.drawee.view.SimpleDraweeView

import kotlinx.android.synthetic.main.item_movie1.view.*


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

        holder.itemMovie1Binding.setVariable(BR.movie, movieList[position])
        holder.itemMovie1Binding.executePendingBindings()
        holder.itemMovie1Binding.movieClick=movieItemClicklistener

    }

    override fun getItemCount(): Int {
        // return timeSlot.size
        return movieList.size
    }

    class MovieViewHolder(var itemMovie1Binding: ItemMovie1Binding) :
        RecyclerView.ViewHolder(itemMovie1Binding.root) {


    }



}