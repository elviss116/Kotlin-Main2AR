package com.example.kotlin_main.listar_coroutines_edm.model

import com.example.kotlin_main.ListarRetrofit.ApiInterface
import com.example.kotlin_main.listar_coroutines_edm.ApiClient3
import com.example.kotlin_main.listar_coroutines_edm.mObject.OperationResult
import com.example.kotlin_main.listar_coroutines_edm.mObject.UsuarioC_E

class UsuarioC_ERepository:UsuarioCEDataSource {

    override suspend fun retrieveUsuarios():OperationResult<UsuarioC_E>{
        val response = ApiInterface.create()?.listaUsersEdm()
        //val response = ApiClient3.build()?.usuarioCR()

        try {
            response?.let {
                return if (it.isSuccessful && it.body()!=null){
                    val data = it.body()?.record
                    OperationResult.Success(data)
                }else{
                    val message = it.errorBody()?.string()
                    OperationResult.Error(Exception(message))
                }
            }?:run{
                return OperationResult.Error(Exception("Ocurrio un error"))
            }
        }catch (e:Exception){
            return OperationResult.Error(e)
        }
    }
}