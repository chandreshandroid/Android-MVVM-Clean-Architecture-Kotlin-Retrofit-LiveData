package com.example.mvvm_kotlin_retrofit_livedata.model
import android.net.Uri
import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView
import com.google.gson.annotations.SerializedName


data class MovieList(
    @SerializedName("Response")
    val response: String = "",
    @SerializedName("Search")
    val search: List<Movie> = listOf(),
    @SerializedName("totalResults")
    val totalResults: String = ""
)

data class Movie    (
    @SerializedName("imdbID")
    val imdbID: String = "",
    @SerializedName("Poster")
    val poster: String = "",
    @SerializedName("Title")
    val title: String = "",
    @SerializedName("Type")
    val type: String = "",
    @SerializedName("Year")
    val year: String = ""
)


@BindingAdapter("imageUrl" )
fun loadImage(view: SimpleDraweeView, url: String) {
    view.setImageURI(Uri.parse(url))
}