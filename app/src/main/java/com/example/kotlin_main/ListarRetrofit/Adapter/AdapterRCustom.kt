package com.example.kotlin_main.Listar.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.ClickListener
import com.example.kotlin_main.Listar.Objeto.Persona
import com.example.kotlin_main.ListarRetrofit.Objeto.Usuario
import com.example.kotlin_main.Login.model.User
import com.example.kotlin_main.R
import kotlinx.android.synthetic.main.model_listar.view.*
import kotlinx.android.synthetic.main.model_listar_r.view.*

class AdapterRCustom(items:List<Usuario>, var clickListener: ClickListener): RecyclerView.Adapter<AdapterRCustom.ViewHolderR>() {
    var items:List<Usuario>? = null
    var viewHolder:ViewHolderR? = null
    init {
        this.items=items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRCustom.ViewHolderR {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.model_listar_r,parent,false)
        viewHolder = ViewHolderR(vista, clickListener)
        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolderR, position: Int) {
        val item = items?.get(position)
        holder.id?.text = item?.id
        holder.pass?.text = item?.password
    }

     class ViewHolderR(vista: View, listener:ClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener{

         var vista = vista
         var pass:TextView? = null
         var id:TextView? = null
         var listener:ClickListener?=null
         init {
             pass=vista.model_r_passTxt
             id=vista.model_r_idTxt
             this.listener=listener
             vista.setOnClickListener(this)
         }

         override fun onClick(v: View?) {
             this.listener?.onClick(v!!,adapterPosition)
         }

     }
}