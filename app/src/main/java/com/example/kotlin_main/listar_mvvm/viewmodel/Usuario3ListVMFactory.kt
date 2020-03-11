package com.example.kotlin_main.listar_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_main.listar_mvvm.model.Usuario3ListRepository

class Usuario3ListVMFactory(val usuario3ListRepository: Usuario3ListRepository): ViewModelProvider.Factory{

    //val usuarioRepository: Usuario3ListRepository

    /*
    init {
        this.usuarioRepository = usuario3ListRepository
    } */

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Usuario3ListViewmodel(usuario3ListRepository) as T
    }
}