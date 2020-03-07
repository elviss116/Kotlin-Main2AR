package com.example.kotlin_main.save_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_main.save_mvvm.SaveListener
import com.example.kotlin_main.save_mvvm.model.UserSRepository

class UserSViewModel : ViewModel(){


//    var saveListener: SaveListener? = null
    val saveResponse = UserSRepository()
    var userSRespuesta = MutableLiveData<String>()


    fun getRespuesta(): MutableLiveData<String>{
        return userSRespuesta
    }


    fun sendData(id: String, pass: String){
        userSRespuesta = saveResponse.userSave(id,pass)
    }


}