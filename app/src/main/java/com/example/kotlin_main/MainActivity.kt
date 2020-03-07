package com.example.kotlin_main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_main.Listar.ListarActivity
import com.example.kotlin_main.ListarRetrofit.ListarRActivity
import com.example.kotlin_main.Login.LoginActivity
import com.example.kotlin_main.save_mvvm.SaveMVVMActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_m_save.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("key", 1)
            startActivity(intent)
        }

        btn_m_listar.setOnClickListener{
            val intent = Intent(this, ListarRActivity::class.java)
            intent.putExtra("key", 1)
            startActivity(intent)
        }

        btn_save_mvvm.setOnClickListener{
            val intent = Intent(this,SaveMVVMActivity::class.java)
            startActivity(intent)

        }


    }
    
}

