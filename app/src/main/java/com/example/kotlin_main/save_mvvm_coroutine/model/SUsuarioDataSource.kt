package com.example.kotlin_main.save_mvvm_coroutine.model

import com.example.kotlin_main.save_mvvm_coroutine.mObject.OperationResult
import com.example.kotlin_main.save_mvvm_coroutine.mObject.UsuarioCoResponse

interface SUsuarioDataSource {
    suspend fun saveUsuarioCoroutines(id: String, pass: String): OperationResult<UsuarioCoResponse>
}