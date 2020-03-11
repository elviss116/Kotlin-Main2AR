package com.example.kotlin_main.ListarRetrofit

import com.example.kotlin_main.ListarRetrofit.Objeto.UserListResponse
import com.example.kotlin_main.Login.model.User
import com.example.kotlin_main.listar_mvvm.mObject.Usuario3Response
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface ApiInterface {

    @FormUrlEncoded
    @POST("retrofit_listar_1.php")
    fun getUser(@Field("key") keyword:String) : Call<UserListResponse>


    @FormUrlEncoded
    @POST("retrofit_listar_1.php")
    fun getUserMvvm(@Field("key") keyword:String) : Call<Usuario3Response>



    companion object{

        var BASE_URL = "http://192.168.1.150:85/faucet/"

        fun create() : ApiInterface{

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS) //Backend is really slow
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}
