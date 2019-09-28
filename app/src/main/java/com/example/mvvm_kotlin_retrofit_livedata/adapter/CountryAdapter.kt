package com.example.mvvm_kotlin_retrofit_livedata.adapter

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_retrofit_livedata.R
import com.example.mvvm_kotlin_retrofit_livedata.model.Country
import com.example.mvvm_kotlin_retrofit_livedata.model.CountryList
import kotlinx.android.synthetic.main.item_country.view.*


class CountryAdapter(
    val context: Activity,

    val countryList: ArrayList<Country?>

) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)

            return CountryViewHolder(v, context)

    }


    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

            holder.bind(countryList[position],position)


    }

    override fun getItemCount(): Int {
        // return timeSlot.size
        return countryList.size
    }

    class CountryViewHolder(itemView: View, context: Activity) : RecyclerView.ViewHolder(itemView) {


        fun bind(country: Country?, position: Int) =
            with(itemView) {
                tvCountry.text=country?.countryName.toString()
            }


    }




}