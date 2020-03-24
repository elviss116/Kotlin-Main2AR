package com.example.kotlin_main.save_mvvm_coroutine.mObject

sealed class OperationResult<out t> {
    data class Success<T>(val message: String?) : OperationResult<T>()
    data class Error(val exception: Exception?) : OperationResult<Nothing>()
}