package com.example.kotlin_main.Listar.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.ClickListener
import com.example.kotlin_main.Listar.Objeto.Persona
import com.example.kotlin_main.R
import kotlinx.android.synthetic.main.model_listar.view.*

class AdapterCustom(items:ArrayList<Persona>, var clickListener: ClickListener): RecyclerView.Adapter<AdapterCustom.ViewHolder>() {

    var items:ArrayList<Persona>? = null
    var viewHolder:ViewHolder? = null

    init {
        this.items=items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCustom.ViewHolder{

        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.model_listar,parent,false)

        viewHolder = ViewHolder(vista, clickListener)

        return viewHolder!!

    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items?.get(position)

        holder.nombre?.text = item?.nombre
        holder.foto?.setImageResource(item?.foto!!)
    }


     class ViewHolder(vista: View, listener:ClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener{


         var vista = vista
         var foto:ImageView? = null
         var nombre:TextView? = null

         var listener:ClickListener?=null

         init {
             foto=vista.imvfoto
             nombre=vista.model_txt_nom

             this.listener=listener
             vista.setOnClickListener(this)
         }

         override fun onClick(v: View?) {
             this.listener?.onClick(v!!,adapterPosition)
         }

     }
}