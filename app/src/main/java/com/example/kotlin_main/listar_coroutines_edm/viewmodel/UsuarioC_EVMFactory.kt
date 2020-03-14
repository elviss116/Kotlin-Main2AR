package com.example.kotlin_main.listar_coroutines_edm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_main.listar_coroutines_edm.model.UsuarioCEDataSource

class UsuarioC_EVMFactory(private val repository: UsuarioCEDataSource):ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsuarioC_EViewModel(repository) as T
    }
}