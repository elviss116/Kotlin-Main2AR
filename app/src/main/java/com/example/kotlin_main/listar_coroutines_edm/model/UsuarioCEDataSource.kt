package com.example.kotlin_main.listar_coroutines_edm.model

import com.example.kotlin_main.listar_coroutines_edm.mObject.OperationResult
import com.example.kotlin_main.listar_coroutines_edm.mObject.UsuarioC_E

interface UsuarioCEDataSource {
    suspend fun retrieveUsuarios():OperationResult<UsuarioC_E>
}