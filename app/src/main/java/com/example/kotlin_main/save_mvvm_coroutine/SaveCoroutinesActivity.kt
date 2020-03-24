package com.example.kotlin_main.save_mvvm_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_main.R
import com.example.kotlin_main.save_mvvm_coroutine.di.Injection
import com.example.kotlin_main.save_mvvm_coroutine.viewmodel.UsuarioSVMFactory
import com.example.kotlin_main.save_mvvm_coroutine.viewmodel.UsuarioSViewModel
import kotlinx.android.synthetic.main.activity_save_coroutines.*

class SaveCoroutinesActivity : AppCompatActivity() {

    private lateinit var viewModel: UsuarioSViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_coroutines)
        configViewModel()
        configView()

    }

    private fun configView(){
        var idS: String
        var pwdS: String

        btn_sUsuarioCo_grabar.setOnClickListener {
            idS = txt_sUsuarioCo_id.text.toString().trim()
            pwdS = txt_sUsuarioCo_pass.text.toString().trim()
            viewModel.saveUsuarios(idS,pwdS)
            viewModel.usuario.observe(this,getRespuesta)

        }
    }

    private fun configViewModel(){
        viewModel = ViewModelProviders.of(this,UsuarioSVMFactory(Injection.providerSUsuarioRepository())).get(UsuarioSViewModel::class.java)
        viewModel.isViewSaving.observe(this,onViewSavingObserver)
    }

    private val getRespuesta = Observer<String> {
        Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
    }

    private val onViewSavingObserver = Observer<Boolean> {
        val visibility= if (it) View.VISIBLE else View.GONE
        progressBarSave.visibility = visibility
    }
    private val onMessageErrorObserver = Observer<Any>{

    }
}
