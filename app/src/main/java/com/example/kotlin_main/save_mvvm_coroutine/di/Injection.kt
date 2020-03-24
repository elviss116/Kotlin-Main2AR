package com.example.kotlin_main.save_mvvm_coroutine.di

import com.example.kotlin_main.save_mvvm_coroutine.model.SUsuarioDataSource
import com.example.kotlin_main.save_mvvm_coroutine.model.UsuarioSRepository

object Injection {
    private val usuariosRepository = UsuarioSRepository()
    fun providerSUsuarioRepository():SUsuarioDataSource = usuariosRepository
}