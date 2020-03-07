package com.example.kotlin_main.Listar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.Adapter.AdapterCustom
import com.example.kotlin_main.Listar.Adapter.AdapterRCustom
import com.example.kotlin_main.Listar.Objeto.Persona
import com.example.kotlin_main.R

class ListarActivity : AppCompatActivity() {

    var personas:ArrayList<Persona>? = null
    var lista:RecyclerView? = null
    var layoutManager:RecyclerView.LayoutManager? = null
    var adaptador:AdapterCustom? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        personas = ArrayList()
        personas?.add(Persona("Marcos",R.drawable.ic_launcher_background))
        personas?.add(Persona("Lucas",R.drawable.ic_launcher_background))
        personas?.add(Persona("Pedro",R.drawable.ic_launcher_background))

        lista = findViewById(R.id.rv_lista)
        layoutManager = LinearLayoutManager(this)
        adaptador = AdapterCustom(personas!!, object: ClickListener{
            override fun onClick(vista: View, position: Int) {
                Toast.makeText(applicationContext, personas?.get(position)?.nombre,Toast.LENGTH_SHORT).show()
            }
        })
        lista?.layoutManager = layoutManager
        lista?.adapter = adaptador
    }
}
