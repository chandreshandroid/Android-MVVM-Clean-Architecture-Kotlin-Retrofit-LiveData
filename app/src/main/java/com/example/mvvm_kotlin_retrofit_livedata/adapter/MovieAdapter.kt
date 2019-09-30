package com.example.mvvm_kotlin_retrofit_livedata.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.model.Movie

import kotlinx.android.synthetic.main.item_movie1.view.*


class MovieAdapter(
    val context: Activity,

    val movieList: ArrayList<Movie?>

) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_movie1, parent, false)

            return MovieViewHolder(v, context)

    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

            holder.bind(movieList[position],position)


    }

    override fun getItemCount(): Int {
        // return timeSlot.size
        return movieList.size
    }

    class MovieViewHolder(itemView: View, context: Activity) : RecyclerView.ViewHolder(itemView) {


        fun bind(movie: Movie?, position: Int) =
            with(itemView) {
                tvTitle.text=movie?.title.toString()
                tvyear.text=movie?.year.toString()
                sdPoster.setImageURI(movie?.poster)

            }


    }




}