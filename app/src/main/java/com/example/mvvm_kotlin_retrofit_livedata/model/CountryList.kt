package com.example.mvvm_kotlin_retrofit_livedata.model

import java.io.Serializable

data class CountryList(
    val `data`: List<Country>,
    val message: String="",
    val status: String=""
):Serializable

data class Country(
    val countryCurrencyCode: String="",
    val countryDialCode: String="",
    val countryFlagImage: String="",
    val countryID: String="",
    val countryISO2Code: String="",
    val countryISO3Code: String="",
    val countryName: String="",
    val countryNameArabic: String="",
    val countryRemarks: String="",
    val countryMinValidation: String="",
    val countryMaxValidation: String=""

):Serializable