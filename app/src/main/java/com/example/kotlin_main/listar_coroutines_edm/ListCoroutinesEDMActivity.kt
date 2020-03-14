package com.example.kotlin_main.listar_coroutines_edm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_main.R
import com.example.kotlin_main.listar_coroutines_edm.adapter.mAdapter
import com.example.kotlin_main.listar_coroutines_edm.di.Injection
import com.example.kotlin_main.listar_coroutines_edm.mObject.UsuarioC_E
import com.example.kotlin_main.listar_coroutines_edm.viewmodel.UsuarioC_EVMFactory
import com.example.kotlin_main.listar_coroutines_edm.viewmodel.UsuarioC_EViewModel
import kotlinx.android.synthetic.main.activity_list_coroutines_edm.*

class ListCoroutinesEDMActivity : AppCompatActivity() {

    private lateinit var viewModel: UsuarioC_EViewModel
    private lateinit var adapter: mAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_coroutines_edm)

        setupViewModel()
        configView()
    }

    private fun configView(){
        adapter= mAdapter(viewModel.usuarios.value?: emptyList())
        rv_listaCoroutiesEdm.layoutManager = LinearLayoutManager(this)
        rv_listaCoroutiesEdm.adapter=adapter
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(this,UsuarioC_EVMFactory(Injection.providerRepository())).get(UsuarioC_EViewModel::class.java)
        viewModel.usuarios.observe(this,renderUsuario)

        viewModel.isViewLoading.observe(this,isViewLoadingObserver)
        viewModel.onMessageError.observe(this,onMessageErrorObserver)
        viewModel.isEmptyList.observe(this,emptyListObserver)
    }


    //observer
    private val renderUsuario = Observer<List<UsuarioC_E>>{
        layoutError.visibility=View.GONE
        layoutEmpty.visibility=View.GONE
        adapter.update(it)
    }

    private val isViewLoadingObserver = Observer<Boolean>{
        val visibility=if (it)View.VISIBLE else View.GONE
        progressBar.visibility = visibility
    }

    private val onMessageErrorObserver = Observer<Any>{
        layoutError.visibility=View.VISIBLE
        layoutEmpty.visibility=View.GONE

    }

    private val emptyListObserver = Observer<Boolean>{
        layoutEmpty.visibility=View.VISIBLE
        layoutError.visibility=View.GONE
    }


    override fun onResume() {
        super.onResume()
        viewModel.loadUsuarios()
    }

}
