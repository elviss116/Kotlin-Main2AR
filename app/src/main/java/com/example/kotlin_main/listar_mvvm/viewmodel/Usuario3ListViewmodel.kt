package com.example.kotlin_main.listar_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_main.listar_mvvm.mObject.Usuario3Response
import com.example.kotlin_main.listar_mvvm.model.Usuario3ListRepository

class Usuario3ListViewmodel : ViewModel() {

    val usuarioListRepository = Usuario3ListRepository()
    var usuarioResponse = MutableLiveData<Usuario3Response>()

    fun getRespuesta(): MutableLiveData<Usuario3Response>{
        return usuarioResponse
    }

    fun sendData(id:String){
        usuarioResponse = usuarioListRepository.getData(id)
    }

}