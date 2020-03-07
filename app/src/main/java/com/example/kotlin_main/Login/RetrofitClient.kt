package com.example.kotlin_main.Login

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import android.util.Base64


object RetrofitClient {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "http://192.168.1.150:85/faucet/"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)
    }
}

