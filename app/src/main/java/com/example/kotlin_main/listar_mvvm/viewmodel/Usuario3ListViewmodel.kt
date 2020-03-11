package com.example.kotlin_main.listar_mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_main.listar_mvvm.mObject.Usuario3Response
import com.example.kotlin_main.listar_mvvm.model.Usuario3ListRepository

class Usuario3ListViewmodel (var usuarioListRepos: Usuario3ListRepository): ViewModel() {

    //private lateinit var usuarioListRepository: Usuario3ListRepository
    var usuarioResponse = MutableLiveData<Usuario3Response>()
    //var usuarioListRepos = Usuario3ListRepository()

    fun getRespuesta(): LiveData<Usuario3Response>{
        return usuarioResponse
    }
    fun sendData(id:String){
        //var usuarioListRepository = Usuario3ListRepository(idk)
        //usuarioListRepo = Usuario3ListRepository()
        //usuarioResponse = usuarioListRepos.getData(id,)
        usuarioListRepos.getData(id,usuarioResponse)
    }
}