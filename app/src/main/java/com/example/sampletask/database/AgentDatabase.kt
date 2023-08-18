package com.example.sampletask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sampletask.Data

@Database(entities = [Data::class], version = 1)
abstract class AgentDatabase : RoomDatabase() {

    abstract fun dao() : dao

    companion object{
        @Volatile
        private var INSTANCE: AgentDatabase? = null

        fun getDatabase(context: Context) : AgentDatabase{

            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        AgentDatabase::class.java,
                        "agentdb")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}