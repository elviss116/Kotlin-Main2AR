package com.example.kotlin_main.listar_mvvm_crutinas.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_main.ListarRetrofit.ApiInterface
import com.example.kotlin_main.listar_mvvm_crutinas.mObject.UsuarioCResponse
import retrofit2.Response

class UsiarioCListRepository{


    suspend fun getData(id: String, mutablePersona: MutableLiveData<UsuarioCResponse>) : Response<UsuarioCResponse>{

        return ApiInterface.create().getUserCMvvm(id)
    }

}