package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class OpcionPixar : AppCompatActivity() {

    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : CategoriasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_opcion_pixar)

        val imgDisney: ImageView
        imgDisney=findViewById(R.id.img_pixar)
        Picasso.get().load("https://tentulogo.com/wp-content/uploads/2018/07/pixar-logo.jpg").into(imgDisney);
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
        categoriaRecicleView = findViewById(R.id.rvPixar)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}