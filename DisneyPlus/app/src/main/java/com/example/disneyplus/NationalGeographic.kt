package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NationalGeographic : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_national_geographic)

        val imgDisney: ImageView
        imgDisney=findViewById(R.id.img_marvel)
        Picasso.get().load("https://www.gannett-cdn.com/presto/2021/01/07/USAT/0d87949b-7f95-4318-a7f7-72f2b6893d05-marvel-shows.png").into(imgDisney);

        val Originales: MutableList<catergoriaItem> = ArrayList()
        Originales.add(catergoriaItem(1, "https://static.wikia.nocookie.net/disney/images/c/cc/22_vs_Earth_poster.jpg/revision/latest?cb=20210516170730&path-prefix=es"))
        Originales.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/image_5e27f8d3.jpeg?region=0,0,648,972"))
        Originales.add(catergoriaItem(1, "https://www.disneylapresspack.com/storage/programs/1624997076_MAW_S1_27x40_ACT43096_LOC_LAS.jpg"))
        Originales.add(catergoriaItem(1, "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2018/04/increibles.jpg?itok=vZzCSlvS"))
        Originales.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/image_bf8739ba.jpeg?region=0,0,540,810"))
        Originales.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_insideout_19751_af12286c.jpeg"))
        Originales.add(catergoriaItem(1, "https://lumiere-a.akamaihd.net/v1/images/p_thegooddinosaur_19753_03c2af0a.jpeg"))

        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Originales",Originales))
        categorias.add(Categorias("Películas",Originales))
        categorias.add(Categorias("Bestias y Mounstruos",Originales))
        categorias.add(Categorias("Cortos",Originales))

        setCategoriasRecycleView(categorias)
    }
    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvMarvel)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}