package com.example.sampletask

import android.app.Application
import com.example.sampletask.database.AgentDatabase
import com.example.sampletask.respository.DataRepository

class AgentApplication : Application() {

    lateinit var dataRepository: DataRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val apidata  = Retrofit.getInstance().create(ApiInterface::class.java)
        val database = AgentDatabase.getDatabase(applicationContext)
        dataRepository = DataRepository(apidata,database)

    }
}