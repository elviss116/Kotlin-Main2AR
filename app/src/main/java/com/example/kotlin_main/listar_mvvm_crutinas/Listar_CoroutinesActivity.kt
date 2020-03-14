package com.example.kotlin_main.listar_mvvm_crutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.ClickListener
import com.example.kotlin_main.R
import com.example.kotlin_main.listar_mvvm_crutinas.adapter.mAdapter
import com.example.kotlin_main.listar_mvvm_crutinas.viewmodel.UsuarioCListViewModel

class Listar_CoroutinesActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    var rv: RecyclerView? = null
    var sv: SearchView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var adaptador: mAdapter? = null

    private lateinit var viewmodel: UsuarioCListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar__coroutines)

        rv = findViewById(R.id.rv_listaretrofit_mvvm_c)
        sv = findViewById(R.id.sv_mvvm)
        layoutManager = LinearLayoutManager(this)
        sv!!.setOnQueryTextListener(this)

        viewmodel = ViewModelProviders.of(this).get(UsuarioCListViewModel::class.java)
        viewmodel.getRespuesta().observe(this, Observer {
            adaptador = mAdapter(it.record!!, object : ClickListener{
                override fun onClick(vista: View, position: Int) {
                    Toast.makeText(applicationContext, it.record?.get(position)?.id, Toast.LENGTH_LONG).show()
                }
            })
            rv?.layoutManager = layoutManager
            rv?.adapter = adaptador

        })
    }

    fun cargar(key: String){

        viewmodel.sendData(key)
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
