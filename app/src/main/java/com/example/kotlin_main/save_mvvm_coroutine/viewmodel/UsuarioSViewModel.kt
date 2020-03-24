package com.example.kotlin_main.save_mvvm_coroutine.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_main.save_mvvm_coroutine.mObject.OperationResult
import com.example.kotlin_main.save_mvvm_coroutine.mObject.UsuarioCoResponse
import com.example.kotlin_main.save_mvvm_coroutine.model.SUsuarioDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioSViewModel(private val repository: SUsuarioDataSource): ViewModel() {

    private val _usuario = MutableLiveData<String>()
    val usuario: LiveData<String> = _usuario

    private val _isViewSaving = MutableLiveData<Boolean>()
    val isViewSaving:LiveData<Boolean> = _isViewSaving

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError:LiveData<Any> = _onMessageError


    fun saveUsuarios(id: String, pass: String){

        viewModelScope.launch {
            var result:OperationResult<UsuarioCoResponse> = withContext(Dispatchers.IO){
                repository.saveUsuarioCoroutines(id,pass)
            }

            when(result){
                is OperationResult.Success ->{
                    if (result.message.isNullOrEmpty()){

                    }else{
                        _usuario.value = result.message
                    }
                }
                is OperationResult.Error ->{
                    _onMessageError.postValue(result.exception)
                }
            }
        }

    }
}