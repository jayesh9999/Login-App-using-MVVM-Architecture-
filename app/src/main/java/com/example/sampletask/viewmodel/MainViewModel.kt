package com.example.sampletask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampletask.Response
import com.example.sampletask.respository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val dataRepository: DataRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.getResponse(9415535550)
        }
    }

    val api :LiveData<Response>
        get() = dataRepository.api

}