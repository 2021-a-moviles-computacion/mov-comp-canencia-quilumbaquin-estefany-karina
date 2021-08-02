package com.example.disneyplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CategoriaItemAdapter(private val contex: Context, private val categoriaItem: List<catergoriaItem>):
    RecyclerView.Adapter<CategoriaItemAdapter.CategoryItemViewHolder>() {

    class CategoryItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageItem: ImageView
        init {
            imageItem = itemView.findViewById(R.id.itemPelícula)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        return CategoryItemViewHolder(LayoutInflater.from(contex).inflate(R.layout.categoria_item_row, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        //holder.imageItem.setImageResource(categoriaItem[position].imagenUrl)
        Picasso.get().load(categoriaItem[position].imagenUrl).into(holder.imageItem)

    }

    override fun getItemCount(): Int {
        return categoriaItem.size
    }
}