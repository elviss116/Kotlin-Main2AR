package com.example.kotlin_main.Login

import com.example.kotlin_main.Login.model.LoginResponse
import com.example.kotlin_main.Login.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api{

    @FormUrlEncoded
    @POST("retrofit_save_k.php")
    fun createUser(
        @Field("id") id:String,
        @Field("password") password:String
        ):Call<LoginResponse>


    @GET("retrofit_listar.php")
    fun getUser(): Call<List<User>>


    /*
    val retrofitInstances: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }*/

}