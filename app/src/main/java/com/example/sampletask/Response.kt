package com.example.sampletask

data class Response(
    val Currentdate: String,
    val Data: List<Data>,
    val Data1: List<Any>,
    val Message: String,
    val Status: Int,
    val Success: Boolean,
    val Userid: Int
)