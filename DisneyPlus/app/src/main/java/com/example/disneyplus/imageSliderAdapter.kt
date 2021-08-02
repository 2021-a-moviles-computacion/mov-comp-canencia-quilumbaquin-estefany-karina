package com.example.disneyplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.squareup.picasso.Picasso

class imageSliderAdapter(private val context: Context, private val slider: List<slider>):
    RecyclerView.Adapter<imageSliderAdapter.SliderViewHolder>(){
    class SliderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imagen: ImageView
        init {
            imagen = itemView.findViewById(R.id.imageview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(context).inflate(R.layout.imageslide, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
       // holder.imagen.setImageResource(slider[position].imagen)
        Picasso.get().load(slider[position].imagen).into(holder.imagen)
    }

    override fun getItemCount(): Int {
        return slider.size
    }
}