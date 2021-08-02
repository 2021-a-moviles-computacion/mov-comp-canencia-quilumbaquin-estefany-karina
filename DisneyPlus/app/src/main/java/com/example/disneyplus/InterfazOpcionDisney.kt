package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class InterfazOpcionDisney : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_interfaz_opcion_disney)
        val imgDisney: ImageView
        imgDisney=findViewById(R.id.img_disney)
        Picasso.get().load("https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/peliculas-para-ninos-cine-infantil/la-transformacion-del-logo-de-disney-en-30-anos/22.aviones-20132/47753026-1-esl-ES/22.Aviones-2013.jpg?resize=980:*").into(imgDisney);
        val ItemPelicula: MutableList<catergoriaItem> = ArrayList()
        ItemPelicula.add(catergoriaItem(1, "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))
        ItemPelicula.add(catergoriaItem(1, "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))
        ItemPelicula.add(catergoriaItem(1, "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))
        ItemPelicula.add(catergoriaItem(1, "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))
        ItemPelicula.add(catergoriaItem(1, "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))
        ItemPelicula.add(catergoriaItem(1, "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))
        ItemPelicula.add(catergoriaItem(1, "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))



        val ItemPelicula2: MutableList<catergoriaItem> = ArrayList()
        ItemPelicula2.add(catergoriaItem(1,"https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))

        val ItemPelicula3: MutableList<catergoriaItem> = ArrayList()
        ItemPelicula3.add(catergoriaItem(1, "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))

        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("CATEGORIA 1",ItemPelicula))
        categorias.add(Categorias("Exitos de cine",ItemPelicula2))
        categorias.add(Categorias("Recomendaciones para ti",ItemPelicula))
        categorias.add(Categorias("Exitos de cine",ItemPelicula2))

        setCategoriasRecycleView(categorias)
    }


    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvDisney)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}