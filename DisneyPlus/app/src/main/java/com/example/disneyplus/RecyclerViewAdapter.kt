package com.example.disneyplus

import android.content.Context
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import java.util.logging.Handler

class RecyclerViewAdapter(private val context: Context, private val recycleViewClass: List<RecycleViewClass>
):
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    class MyViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        var Img: RecyclerView
        var itemRecycle1: RecyclerView
        var slider: RecyclerView

        init{
            Img = ItemView.findViewById(R.id.img)
            itemRecycle1 = ItemView.findViewById(R.id.rvGeneral)
            slider = ItemView.findViewById(R.id.rvSlider)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return RecyclerViewAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.opcione_rv, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.slider.setImageList(recycleViewClass[position].slider)
        setImagenRecycler(holder.slider, recycleViewClass[position].slider)
        setCatIRecycler(holder.itemRecycle1, recycleViewClass[position].categorias)
        setCatIRecycler2(holder.Img, recycleViewClass[position].itemOptio)

    }

    override fun getItemCount(): Int {
        return recycleViewClass.size
    }

    private fun setImagenRecycler(recyclerView: RecyclerView, slider: List<slider>){
        val itemRecyclerAdapter = imageSliderAdapter(context, slider)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter
    }

   private fun setCatIRecycler(recyclerView: RecyclerView,categorias: List<Categorias>){
       val itemRecyclerAdapter = CategoriasAdapter(context, categorias)
       val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
       recyclerView!!.layoutManager = layoutManager
       recyclerView.adapter = itemRecyclerAdapter
    }

    private fun setCatIRecycler2(recyclerView: RecyclerView, itemOptio: List<ItemOpcion>){
        val itemRecyclerAdapter = ItemOpctionAdapter(context, itemOptio)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter
    }
}