package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var ImagenesRecicleView : RecyclerView?=null
    private var botonesRecycle: RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null
    private var recyclerImagenes: imageSliderAdapter?=null
    private var botones: ItemOpctionAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)


        //Opciones Disney Pixar
        val OpcionesCategorias: MutableList<ItemOpcion> = ArrayList()
        OpcionesCategorias.add(ItemOpcion(R.drawable.disney))
        OpcionesCategorias.add(ItemOpcion(R.drawable.pixar))
        OpcionesCategorias.add(ItemOpcion(R.drawable.marvel))
        OpcionesCategorias.add(ItemOpcion(R.drawable.star_wars))
        OpcionesCategorias.add(ItemOpcion(R.drawable.national))


        //Peliculas
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
        categorias.add(Categorias("Recomendaciones para ti",ItemPelicula))
        categorias.add(Categorias("Exitos de cine",ItemPelicula2))
        categorias.add(Categorias("Recomendaciones para ti",ItemPelicula))
        categorias.add(Categorias("Exitos de cine",ItemPelicula2))

        val slider: MutableList<slider> = ArrayList()
        slider.add(slider(" para ti","https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))
        slider.add(slider("Exitos de cine","https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/4065_big.jpg"))

        setImagenesRecycleView(slider)
        setBotonesRecycleView(OpcionesCategorias)
        setCategoriasRecycleView(categorias)

    }

    private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvRecycleInicio)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }

    private fun setImagenesRecycleView(slider: List<slider>){
        ImagenesRecicleView = findViewById(R.id.rvImagenes)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        ImagenesRecicleView!!.layoutManager = layoutManager
        recyclerImagenes = imageSliderAdapter(this, slider)
        ImagenesRecicleView!!.adapter = recyclerImagenes
    }

    private fun setBotonesRecycleView(itemOpcion: List<ItemOpcion>){
        botonesRecycle = findViewById(R.id.rvBotones)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        botonesRecycle!!.layoutManager = layoutManager
        botones = ItemOpctionAdapter(this, itemOpcion)
        botonesRecycle!!.adapter = botones
    }

    /*private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvRecycleInicio)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = RecyclerViewAdapter(this, recycleViewClass)
        categoriaRecicleView!!.adapter = recycleAdapter
    }*/

}