package com.example.moviles_computacion_2021_b

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FRecycleViewAdaptadorNombreCedula (
    private val contexto: GRecycleView,
    private val listaEntrenador: List<BEntrenador>,
    private val recyclerView: RecyclerView
): RecyclerView.Adapter<FRecycleViewAdaptadorNombreCedula.MyViewHolder>(){
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nombreTextView: TextView
    val cedulaTextView: TextView
    val likesTextView: TextView
    val accionButton: Button
    var numeroLikes = 0

        init {
            nombreTextView = view.findViewById(R.id.tv_nombre)
            cedulaTextView = view.findViewById(R.id.tv_cedula)
            likesTextView = view.findViewById(R.id.tv_likes)
            accionButton = view.findViewById(R.id.btn_dar_like)
            accionButton.setOnClickListener {
                this.anadirLike()
            }

        }
        fun anadirLike(){
            this.numeroLikes = this.numeroLikes+1
            likesTextView.text= this.numeroLikes.toString()
            contexto.aumentarTotalLikes()
        }

    }

    //Tamaño del arreglo
    //setear layou que vamos a utlizar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.recycler_view_vista,
                parent,
                false,
            )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val entrenador = listaEntrenador[position]
        holder.nombreTextView.text = entrenador.nombre
        holder.cedulaTextView.text = entrenador.descripcion
        holder.accionButton.text = "like ${entrenador.nombre}"
        holder.likesTextView.text = "0"
        }

    override fun getItemCount(): Int {
        return listaEntrenador.size
    }
}