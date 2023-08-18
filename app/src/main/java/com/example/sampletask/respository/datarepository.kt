package com.example.sampletask.respository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sampletask.ApiInterface
import com.example.sampletask.Response
import com.example.sampletask.database.AgentDatabase

class DataRepository(private val apiInterface: ApiInterface,private val agentDatabase: AgentDatabase) {

    private val apiLiveData = MutableLiveData<Response>()

    val api : LiveData<Response>
        get() = apiLiveData

    suspend fun getResponse(mobileno : Long){
        val result = apiInterface.getResponse(mobileno)
        if (result?.body() != null){
            agentDatabase.dao().addAgent(result.body()!!.Data)
            apiLiveData.postValue(result.body())
        }
    }
}