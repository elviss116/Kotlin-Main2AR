package com.example.kotlin_main.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_main.Login.model.LoginResponse
import com.example.kotlin_main.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn_ok.setOnClickListener {

            val id = txt_id.text.toString().trim()
            val pwd = txt_pass.text.toString().trim()

            RetrofitClient.instance.createUser(id,pwd)
                .enqueue(object: Callback<LoginResponse>{
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        Toast.makeText(applicationContext,response.body()?.message,Toast.LENGTH_LONG).show()
                    }

                })

        }


    }


}
