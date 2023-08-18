package com.example.sampletask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.sampletask.databinding.ActivityMainBinding
import com.example.sampletask.respository.DataRepository
import com.example.sampletask.viewmodel.MainViewModel
import com.example.sampletask.viewmodel.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val anim = binding.animation

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            anim.visibility = View.VISIBLE
            anim.playAnimation()
        },1000)

        val repository = (application as AgentApplication).dataRepository

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.api.observe(this, Observer {
            Log.d("Check ViewModel",it.Data.toString())
        })

        binding.editText.addTextChangedListener(
            afterTextChanged = {
                val blockedNumbers = listOf("0","1","2","3","4","5")
                if (!it.isNullOrBlank() && blockedNumbers.contains(it[0].toString())) {
                    it.delete(0, 1)
                    binding.textInputLayout.error = "Enter Valid Number"
                }else{
                    binding.textInputLayout.error = null
                }
            }
        )

//        val apiInterface = Retrofit.getInstance().create(ApiInterface::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            val result = apiInterface.getResponse(9415535550)
//            Log.d("Check",result.body().toString())
//        }

    }
}