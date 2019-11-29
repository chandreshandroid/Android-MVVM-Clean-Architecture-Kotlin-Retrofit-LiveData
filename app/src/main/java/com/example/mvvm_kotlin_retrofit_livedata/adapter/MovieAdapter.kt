package com.example.mvvm_kotlin_retrofit_livedata.adapter

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.databinding.ItemMovie1Binding
import com.example.mvvm_kotlin_retrofit_livedata.listener.CustomItemClickListener
import com.example.mvvm_kotlin_retrofit_livedata.model.Movie
import com.facebook.drawee.view.SimpleDraweeView


class MovieAdapter(
    val context: Activity,

    val movieList: ArrayList<Movie?>,

var itemClickListener: CustomItemClickListener

) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val binding = DataBindingUtil.inflate<ItemMovie1Binding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie1, parent, false
        )

        return MovieViewHolder(binding,context)

            /*val v = LayoutInflater.from(parent.context).inflate(R.layout.item_movie1, parent, false)

            return MovieViewHolder(v, context)*/

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {



        holder.itemRowBinding.setVariable(BR.movie, movieList[position])
        holder.itemRowBinding.executePendingBindings()
        holder.itemRowBinding.itemClickListener=itemClickListener
    }

    override fun getItemCount(): Int {
        // return timeSlot.size
        return movieList.size
    }

    class MovieViewHolder(var itemRowBinding: ItemMovie1Binding, context: Activity) : RecyclerView.ViewHolder(itemRowBinding.getRoot()) {



    }




}