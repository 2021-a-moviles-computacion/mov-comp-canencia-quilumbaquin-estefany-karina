package com.example.moviles_computacion_2021_b

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter : RecyclerView.Adapter<UsuarioAdapter.usuarioView>() {

    private var stdList: ArrayList<EUsuarioBDD> = ArrayList()

    fun addItems(Items: ArrayList<EUsuarioBDD>){
        this.stdList = Items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = usuarioView (
        LayoutInflater.from(parent.context).inflate(R.layout.items_std, parent, false)
    )

    override fun onBindViewHolder(holder: usuarioView, position: Int) {
        val std = stdList[position]
        holder.bindView(std)
    }

    override fun getItemCount(): Int {
        return stdList.size
    }

    class usuarioView(var view: View): RecyclerView.ViewHolder(view){
        private var id= view.findViewById<TextView>(R.id.tvId)
        private var Nombre=view.findViewById<TextView>(R.id.tvNombre)
        private var Descripcion=view.findViewById<TextView>(R.id.tvDescripcion)
        private var btnBorrar=view.findViewById<Button>(R.id.btnBorrar)

        fun bindView(std: EUsuarioBDD){
            id.text = std.id.toString()
            Nombre.text = std.nombre.toString()
            Descripcion.text = std.descripcion.toString()
        }
    }
}