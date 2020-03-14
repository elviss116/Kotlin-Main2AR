package com.example.kotlin_main.listar_coroutines_edm.di

import com.example.kotlin_main.listar_coroutines_edm.model.UsuarioCEDataSource
import com.example.kotlin_main.listar_coroutines_edm.model.UsuarioC_ERepository

object Injection {
    private val usuarioRepository = UsuarioC_ERepository()
    fun providerRepository():UsuarioCEDataSource = usuarioRepository

}