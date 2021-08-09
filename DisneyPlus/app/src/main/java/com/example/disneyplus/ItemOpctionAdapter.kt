package com.example.disneyplus

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ItemOpctionAdapter(private val context: Context, private val itemoption: List<ItemOpcion>):
    RecyclerView.Adapter<ItemOpctionAdapter.CategoryItemViewHolder>() {
    class CategoryItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val imageItemOpcion: ImageView
        init {
            imageItemOpcion = itemView.findViewById(R.id.itemOpciones)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        return CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_opcion_categorias, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.imageItemOpcion.setImageResource(itemoption[position].imagenUrl)
        holder.imageItemOpcion .setOnClickListener {
        var img = itemoption[position].imagenUrl
            if(position==0){
                var intent = Intent(context, InterfazOpcionDisney::class.java )
                context.startActivity(intent)}
            if(position==1){
                var intent = Intent(context, OpcionPixar::class.java )
                context.startActivity(intent)}
            if(position==2){
                var intent = Intent(context, Marvel::class.java )
                context.startActivity(intent)}
            if(position==3){
                var intent = Intent(context, StarWars::class.java )
                context.startActivity(intent)}
            if(position==4){
                var intent = Intent(context, NationalGeographic::class.java )
                context.startActivity(intent)}
        }
    }

    override fun getItemCount(): Int {
        return itemoption.size
    }



}