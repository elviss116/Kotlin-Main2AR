package com.example.kotlin_main.listar_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.Adapter.AdapterRCustom
import com.example.kotlin_main.Listar.ClickListener
import com.example.kotlin_main.R
import com.example.kotlin_main.listar_mvvm.adapter.mAdapter
import com.example.kotlin_main.listar_mvvm.viewmodel.Usuario3ListViewmodel

class ListarMvvmActivity : AppCompatActivity(), SearchView.OnQueryTextListener {


    var rv: RecyclerView? = null
    var sv: SearchView? = null
    var layoutManager:RecyclerView.LayoutManager? = null
    var adaptador:mAdapter? = null
    var viewmodel: Usuario3ListViewmodel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_mvvm)
        rv = findViewById(R.id.rv_listaretrofit_mvvm)
        sv = findViewById(R.id.sv_mvvm)
        layoutManager = LinearLayoutManager(this)
        sv!!.setOnQueryTextListener(this)
        viewmodel = ViewModelProviders.of(this).get(Usuario3ListViewmodel::class.java)

        cargar("")
    }

    fun cargar(key: String = ""){
        viewmodel!!.sendData(key)
        viewmodel!!.getRespuesta().observe(this, Observer {
            adaptador = mAdapter(it.record!!, object : ClickListener{
                override fun onClick(vista: View, position: Int) {
                    return
                }
            })
        })

        rv?.layoutManager = layoutManager
        rv?.adapter = adaptador

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        cargar(query!!)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        cargar(newText!!)
        return false
    }
}
