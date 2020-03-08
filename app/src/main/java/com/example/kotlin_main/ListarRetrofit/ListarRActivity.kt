package com.example.kotlin_main.ListarRetrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.Adapter.AdapterRCustom
import com.example.kotlin_main.Listar.ClickListener
import com.example.kotlin_main.ListarRetrofit.Objeto.UserListResponse
import com.example.kotlin_main.Login.model.User
import com.example.kotlin_main.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListarRActivity : AppCompatActivity(), SearchView.OnQueryTextListener {


    override fun onQueryTextSubmit(query: String?): Boolean {
        cargar(query!!)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        cargar(newText!!)
        return false
    }

    var user:List<User>? = null
    var lista: RecyclerView? = null
    var sv: SearchView? = null
    var layoutManager:RecyclerView.LayoutManager? = null
    var adaptador:AdapterRCustom? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_r)
        lista = findViewById(R.id.rv_listaretrofit)
        sv = findViewById(R.id.sv)
        layoutManager = LinearLayoutManager(this)


        sv!!.setOnQueryTextListener(this)


        cargar("")


    }

    fun cargar(key : String){

        var api = ApiInterface.create().getUser(key)
        api.enqueue( object : Callback<UserListResponse>{
            override fun onFailure(call: Call<UserListResponse>, t: Throwable) {

            }
            override fun onResponse(call: Call<UserListResponse>, response: Response<UserListResponse>) {
                if (response?.body() != null )
                    println(response?.body())
                val userR = response.body()!! as UserListResponse
                //adaptador = AdapterRCustom( UserListResponse(response.body()!!,null))
                adaptador = AdapterRCustom(userR.record, object: ClickListener{
                    override fun onClick(vista: View, position: Int) {

                        return
                    }

                })

                lista?.layoutManager = layoutManager
                lista?.adapter = adaptador

            }
        })
    }

}
