package com.example.sampletask.database

import androidx.room.TypeConverter

class Convertors {

    @TypeConverter
    fun fromBooleantoString(value : Boolean): String {
        return Boolean.toString()
    }

}