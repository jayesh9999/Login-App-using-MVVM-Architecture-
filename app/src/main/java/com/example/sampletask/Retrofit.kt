package com.example.sampletask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    val base_Url = "http://myapp.dataupload.in"

    fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}