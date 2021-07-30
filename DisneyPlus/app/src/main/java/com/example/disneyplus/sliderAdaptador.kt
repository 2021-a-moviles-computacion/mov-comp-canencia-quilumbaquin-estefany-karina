package com.example.disneyplus

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider

class sliderAdaptador(private var context:Context, private val slider: List<Slider>):
    RecyclerView.Adapter<sliderAdaptador.SliderItemViewHolder>(){
    class SliderItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
          var imageItem: ImageSlider
        init {
             imageItem = itemView.findViewById(R.id.slider)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SliderItemViewHolder, position: Int) {
        holder.imageItem.setImageList(Slider[position].nombreImagen)
    }

    override fun getItemCount(): Int {
        return slider.size
    }
    }