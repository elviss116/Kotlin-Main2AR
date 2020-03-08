package com.example.kotlin_main.listar_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_main.Listar.Adapter.AdapterRCustom
import com.example.kotlin_main.Listar.ClickListener
import com.example.kotlin_main.R
import com.example.kotlin_main.listar_mvvm.mObject.Usuario3
import kotlinx.android.synthetic.main.model_listar_r.view.*

class mAdapter(items:List<Usuario3>, var clickListener: ClickListener): RecyclerView.Adapter<mAdapter.ViewHolderRMVVM>() {
    var items:List<Usuario3>? = null
    var viewHolder:ViewHolderRMVVM? = null
    init {
        this.items=items
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mAdapter.ViewHolderRMVVM {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.model_listar_r,parent,false)
        viewHolder = ViewHolderRMVVM(vista, clickListener)
        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    override fun onBindViewHolder(holder: ViewHolderRMVVM, position: Int) {
        val item = items?.get(position)
        holder.id?.text = item?.id
        holder.pass?.text = item?.password
    }

    class ViewHolderRMVVM(vista: View, listener:ClickListener): RecyclerView.ViewHolder(vista), View.OnClickListener{

        var vista = vista
        var pass: TextView? = null
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