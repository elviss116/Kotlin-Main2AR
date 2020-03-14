package com.example.kotlin_main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_main.Listar.ListarActivity
import com.example.kotlin_main.ListarRetrofit.ListarRActivity
import com.example.kotlin_main.Login.LoginActivity
import com.example.kotlin_main.listar_coroutines_edm.ListCoroutinesEDMActivity
import com.example.kotlin_main.listar_mvvm.ListarMvvmActivity
import com.example.kotlin_main.listar_mvvm_crutinas.Listar_CoroutinesActivity
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

        btn_listar_mvvm.setOnClickListener{
            val intent = Intent(this,ListarMvvmActivity::class.java)
            startActivity(intent)
        }

        btn_listar_mvvm_coroutines.setOnClickListener{
            val intent = Intent(this,Listar_CoroutinesActivity::class.java)
            startActivity(intent)
        }

        btn_listar_mvvm_coroutinesEM.setOnClickListener{
            val intent = Intent(this,ListCoroutinesEDMActivity::class.java)
            startActivity(intent)
        }


    }
    
}

