package com.example.kotlin_main.listar_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.Adapter.AdapterRCustom
import com.example.kotlin_main.Listar.ClickListener
import com.example.kotlin_main.R
import com.example.kotlin_main.listar_mvvm.adapter.mAdapter
import com.example.kotlin_main.listar_mvvm.model.Usuario3ListRepository
import com.example.kotlin_main.listar_mvvm.viewmodel.Usuario3ListVMFactory
import com.example.kotlin_main.listar_mvvm.viewmodel.Usuario3ListViewmodel
import kotlinx.android.synthetic.main.activity_listar_mvvm.*

class ListarMvvmActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    override fun onQueryTextSubmit(query: String?): Boolean {
        cargar(query!!)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        cargar(newText!!)
        return true
    }
    //lateinit var vmFactory: Usuario3ListVMFactory
    var rv: RecyclerView? = null
    var sv: SearchView? = null
    var layoutManager:RecyclerView.LayoutManager? = null
    var adaptador:mAdapter? = null
    var vacio: String = ""
    //private var usuario3ListRepository = Usuario3ListRepository()
    private lateinit var viewmodel: Usuario3ListViewmodel
    lateinit var vmFactory: Usuario3ListVMFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_mvvm)
        vmFactory = Usuario3ListVMFactory(Usuario3ListRepository())
        rv = findViewById(R.id.rv_listaretrofit_mvvm)
        sv = findViewById(R.id.sv_mvvm)
        layoutManager = LinearLayoutManager(this)
        sv!!.setOnQueryTextListener(this)

        viewmodel = ViewModelProviders.of(this,vmFactory).get(Usuario3ListViewmodel::class.java)
        viewmodel.getRespuesta().observe(this, Observer {
            adaptador = mAdapter(it.record!!, object : ClickListener{
                override fun onClick(vista: View, position: Int) {
                    Toast.makeText(applicationContext, it.record?.get(position)?.id,Toast.LENGTH_LONG).show()
                }
            })
            rv?.layoutManager = layoutManager
            rv?.adapter = adaptador
        })

        cargar("")
    }

    fun cargar(key: String){
        viewmodel.sendData(key)
    }
}
