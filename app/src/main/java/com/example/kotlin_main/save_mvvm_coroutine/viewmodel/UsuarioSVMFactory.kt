package com.example.kotlin_main.save_mvvm_coroutine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_main.save_mvvm_coroutine.model.SUsuarioDataSource

class UsuarioSVMFactory(private val repository: SUsuarioDataSource): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsuarioSViewModel(repository) as T
    }
}