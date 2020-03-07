package com.example.kotlin_main.save_mvvm

import androidx.lifecycle.LiveData

interface SaveListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}