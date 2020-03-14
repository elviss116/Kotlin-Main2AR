package com.example.kotlin_main.listar_coroutines_edm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_main.listar_coroutines_edm.mObject.OperationResult
import com.example.kotlin_main.listar_coroutines_edm.mObject.UsuarioC_E
import com.example.kotlin_main.listar_coroutines_edm.model.UsuarioCEDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioC_EViewModel(private val repository: UsuarioCEDataSource): ViewModel(){

    private val _usuarios = MutableLiveData<List<UsuarioC_E>>().apply { value = emptyList() }
    val usuarios: LiveData<List<UsuarioC_E>> = _usuarios

    private val _isViewLoading=MutableLiveData<Boolean>()
    val isViewLoading:LiveData<Boolean> = _isViewLoading

    private val _onMessageError=MutableLiveData<Any>()
    val onMessageError:LiveData<Any> = _onMessageError

    private val _isEmptyList=MutableLiveData<Boolean>()
    val isEmptyList:LiveData<Boolean> = _isEmptyList

    fun cancel(){
        viewModelScope.cancel()
    }


    fun loadUsuarios(){
        _isViewLoading.postValue(true)
        viewModelScope.launch {
            var result:OperationResult<UsuarioC_E> = withContext(Dispatchers.IO){
                repository.retrieveUsuarios()
            }
            _isViewLoading.postValue(false)
            when(result){
                is OperationResult.Success ->{
                    if (result.record.isNullOrEmpty()){
                        _isEmptyList.postValue(true)
                    }else{
                        _usuarios.value = result.record
                    }
                }
                is OperationResult.Error ->{
                    _onMessageError.postValue(result.exception)
                }
            }
        }
    }
}