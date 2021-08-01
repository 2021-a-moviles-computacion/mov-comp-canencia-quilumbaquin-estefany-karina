package com.example.disneyplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoriasAdapter(private val context: Context, private val Categorias: List<Categorias>
):
    RecyclerView.Adapter<CategoriasAdapter.MViewHolder>() {
        class MViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
            var tituloCategoria: TextView
            var itemRecycle: RecyclerView
            init{
                tituloCategoria = ItemView.findViewById(R.id.txtNombreCat)
                itemRecycle = ItemView.findViewById(R.id.rv_ItemPeliculas)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recicly_view_row_item, parent, false))
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.tituloCategoria.text = Categorias[position].tituloCategoria
        setCatItemRecycler(holder.itemRecycle, Categorias[position].catergoriaItem)
    }

    override fun getItemCount(): Int {
        return Categorias.size
    }

    private fun setCatItemRecycler(recyclerView: RecyclerView, catergoriaItem: List<catergoriaItem>){
        val itemRecyclerAdapter = CategoriaItemAdapter(context, catergoriaItem)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter
    }

}