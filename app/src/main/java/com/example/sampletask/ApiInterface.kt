package com.example.sampletask

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/Verify")
    suspend fun getResponse(@Query("mobileno") mobileno : Long): Response<com.example.sampletask.Response>
}