package com.example.kotlin_main.listar_mvvm_crutinas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_main.listar_mvvm_crutinas.mObject.UsuarioCResponse
import com.example.kotlin_main.listar_mvvm_crutinas.model.UsiarioCListRepository
import com.example.kotlin_main.utils.Coroutines
import java.lang.Exception

class UsuarioCListViewModel: ViewModel() {

    var usuarioResponse = MutableLiveData<UsuarioCResponse>()

    fun getRespuesta(): LiveData<UsuarioCResponse> {
        return usuarioResponse
    }
    fun sendData(id:String){
        Coroutines.main {
            val response = UsiarioCListRepository().getData(id,usuarioResponse)
            if (response.isSuccessful){
                //UsuarioCResponse(response.body()?.record!!,null)
                //usuarioListRepos = UsuarioCResponse(response.body()?.record!!,null)
                usuarioResponse.value = UsuarioCResponse(response.body()!!.record,null)
            }else{
                usuarioResponse.value = UsuarioCResponse(null,Exception(response.errorBody().toString()))
            }
        }
    }
}