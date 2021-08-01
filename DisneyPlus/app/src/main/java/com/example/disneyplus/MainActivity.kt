package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : RecyclerViewAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)


        //Opciones Disney Pixar
        val OpcionesCategorias: MutableList<ItemOptio> = ArrayList()
        OpcionesCategorias.add(ItemOptio(R.drawable.disney))
        OpcionesCategorias.add(ItemOptio(R.drawable.disney))
        OpcionesCategorias.add(ItemOptio(R.drawable.marvel))
        OpcionesCategorias.add(ItemOptio(R.drawable.disney))
        OpcionesCategorias.add(ItemOptio(R.drawable.disney))


        //Peliculas
        val ItemPelicula: MutableList<catergoriaItem> = ArrayList()
        ItemPelicula.add(catergoriaItem(1, R.drawable.avatar))
        ItemPelicula.add(catergoriaItem(1, R.drawable.avengers))
        ItemPelicula.add(catergoriaItem(1, R.drawable.avengers))
        ItemPelicula.add(catergoriaItem(1, R.drawable.avengers))
        ItemPelicula.add(catergoriaItem(1, R.drawable.avengers))
        ItemPelicula.add(catergoriaItem(1, R.drawable.avengers))
        ItemPelicula.add(catergoriaItem(1, R.drawable.avengers))



        val ItemPelicula2: MutableList<catergoriaItem> = ArrayList()
        ItemPelicula2.add(catergoriaItem(1, R.drawable.avengers))

        val ItemPelicula3: MutableList<catergoriaItem> = ArrayList()
        ItemPelicula3.add(catergoriaItem(1, R.drawable.avengers))

        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Recomendaciones para ti",ItemPelicula))
        categorias.add(Categorias("Exitos de cine",ItemPelicula2))
        categorias.add(Categorias(" para ti",ItemPelicula3))
        categorias.add(Categorias("Recomendaciones  ti",ItemPelicula2))

        val recycle: MutableList<RecycleViewClass> = ArrayList()
        recycle.add(RecycleViewClass(OpcionesCategorias,categorias))

        setCategoriasRecycleView(recycle)

    }

    /*private fun setCategoriasRecycleView(categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvRecycleInicio)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = CategoriasAdapter(this, categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }*/

    private fun setCategoriasRecycleView(recycleViewClass: List<RecycleViewClass>){
        categoriaRecicleView = findViewById(R.id.rvRecycleInicio)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = RecyclerViewAdapter(this, recycleViewClass)
        categoriaRecicleView!!.adapter = recycleAdapter
    }

}