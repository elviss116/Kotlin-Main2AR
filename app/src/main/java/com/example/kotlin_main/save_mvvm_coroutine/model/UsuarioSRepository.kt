package com.example.kotlin_main.save_mvvm_coroutine.model

import com.example.kotlin_main.ListarRetrofit.ApiInterface
import com.example.kotlin_main.save_mvvm_coroutine.mObject.OperationResult
import com.example.kotlin_main.save_mvvm_coroutine.mObject.UsuarioCoResponse

class UsuarioSRepository: SUsuarioDataSource {


    override suspend fun saveUsuarioCoroutines(id:String, pass: String): OperationResult<UsuarioCoResponse> {
        val response = ApiInterface.create()?.saveUserCoroutines(id,pass)


        try {
            response?.let {
                return if (it.isSuccessful && it.body()!=null){
                    val data = it.body()?.message
                    OperationResult.Success(data)
                }else{
                    val message = it.errorBody()?.string()
                    OperationResult.Error(Exception(message))
                }
            }?:run {
                return OperationResult.Error(Exception("Ocurrio n error"))
            }
        }catch (e: Exception){
            return OperationResult.Error(e)
        }
    }
}