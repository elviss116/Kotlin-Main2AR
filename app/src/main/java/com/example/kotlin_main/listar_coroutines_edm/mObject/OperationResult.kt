package com.example.kotlin_main.listar_coroutines_edm.mObject

sealed class OperationResult<out T> {
    data class Success<T>(val record: List<T>?) : OperationResult<T>()
    data class Error(val exception:Exception?) : OperationResult<Nothing>()
}