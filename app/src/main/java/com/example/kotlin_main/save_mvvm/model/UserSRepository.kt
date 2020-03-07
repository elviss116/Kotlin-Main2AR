package com.example.kotlin_main.save_mvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_main.Login.RetrofitClient
import com.example.kotlin_main.Login.model.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserSRepository {

    fun userSave(id: String, password : String) : MutableLiveData<String>{

        val userSResponse = MutableLiveData<String>()

        RetrofitClient.instance.createUser(id,password)
            .enqueue(object: Callback<LoginResponse>{
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    userSResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful){
                        userSResponse.value = response.body()?.message
                    }else{
                        userSResponse.value = response.errorBody()?.string()
                    }
                }
            })

        return userSResponse

    }
}