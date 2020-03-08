package com.example.kotlin_main.ListarRetrofit

import com.example.kotlin_main.ListarRetrofit.Objeto.UserListResponse
import com.example.kotlin_main.Login.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("retrofit_listar_1.php")
    fun getUser(@Field("key") keyword:String) : Call<UserListResponse>

    companion object{
        var BASE_URL = "http://192.168.1.150:85/faucet/"

        fun create() : ApiInterface{

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}