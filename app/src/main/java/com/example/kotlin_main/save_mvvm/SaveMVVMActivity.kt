package com.example.kotlin_main.save_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_main.R
import com.example.kotlin_main.save_mvvm.viewmodel.UserSViewModel
import kotlinx.android.synthetic.main.activity_save_mvvm.*

class SaveMVVMActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_mvvm)

        val viewmodel = ViewModelProviders.of(this).get(UserSViewModel::class.java)
        //viewmodel.saveListener = this

        btn_save_mvvm_grabar.setOnClickListener{

            val id = txt_save_mvvm_id.text.toString().trim()
            val pwd = txt_save_mvvm_pass.text.toString().trim()

            viewmodel.sendData(id,pwd)
            viewmodel.getRespuesta().observe(this, Observer {
                Toast.makeText(applicationContext,it, Toast.LENGTH_LONG).show()
            })
        }

    }

}
