package com.example.disneyplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context, private val recycleViewClass: List<RecycleViewClass>
):
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    class MyViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        var Img: RecyclerView
        var itemRecycle1: RecyclerView

        init{
            Img = ItemView.findViewById(R.id.img)
            itemRecycle1 = ItemView.findViewById(R.id.rvGeneral)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return RecyclerViewAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.opcione_rv, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        setCatIRecycler(holder.itemRecycle1, recycleViewClass[position].categorias)
        setCatIRecycler2(holder.Img, recycleViewClass[position].itemOptio)

    }

    override fun getItemCount(): Int {
        return recycleViewClass.size
    }
   private fun setCatIRecycler(recyclerView: RecyclerView, categorias: List<Categorias>){
        val itemRecyclerAdapter = CategoriasAdapter(context, categorias)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = itemRecyclerAdapter
    }

    private fun setCatIRecycler2(recyclerView: RecyclerView, itemOptio: List<ItemOptio>){
        val itemRecyclerAdapter = ItemOpctionAdapter(context, itemOptio)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter
    }
}