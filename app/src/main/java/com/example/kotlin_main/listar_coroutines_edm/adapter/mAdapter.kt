package com.example.kotlin_main.listar_coroutines_edm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.ClickListener
import com.example.kotlin_main.R
import com.example.kotlin_main.listar_coroutines_edm.mObject.UsuarioC_E
import kotlinx.android.synthetic.main.model_listar_r.view.*

class mAdapter(private var usuarios:List<UsuarioC_E>, var clickListener: ClickListener): RecyclerView.Adapter<mAdapter.ViewHolderC_E>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mAdapter.ViewHolderC_E {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.model_listar_r,parent,false)

        return ViewHolderC_E(vista,clickListener)
    }

    override fun getItemCount(): Int {
        return this.usuarios.size
    }

    override fun onBindViewHolder(holder: ViewHolderC_E, position: Int) {
        val usuario = usuarios[position]

        holder.id.text = usuario.id
        holder.pass.text = usuario.password
    }

    fun update(data:List<UsuarioC_E>){
        usuarios = data
        notifyDataSetChanged()
    }
    class ViewHolderC_E(val view: View, listener:ClickListener): RecyclerView.ViewHolder(view), View.OnClickListener{

        var pass: TextView = view.findViewById(R.id.model_r_idTxt)
        var id:TextView = view.findViewById(R.id.model_r_passTxt)
        var listener:ClickListener = listener

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!,adapterPosition)
        }


    }
}