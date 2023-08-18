package com.example.sampletask.database

import android.database.CursorJoiner
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sampletask.Data
import retrofit2.http.GET

@Dao
interface dao {
    @Insert
    suspend fun addAgent(agent: List<Data>)

    @Query("SELECT * FROM agentdata")
    suspend fun getAgent() : List<Data>

}