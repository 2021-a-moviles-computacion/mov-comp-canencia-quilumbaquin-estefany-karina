package com.example.disneyplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var categoriaRecicleView : RecyclerView?=null
    private var recycleAdapter : RecycleViewAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_main)
        //Peliculas
        val ItemPelicula: MutableList<catergoriaItem> = ArrayList()
        ItemPelicula.add(catergoriaItem(1, R.drawable.avatar))

        val ItemPelicula2: MutableList<catergoriaItem> = ArrayList()
        ItemPelicula2.add(catergoriaItem(1, R.drawable.avengers))


        val categorias: MutableList<Categorias> = ArrayList()
        categorias.add(Categorias("Recomendaciones para ti",ItemPelicula))
        categorias.add(Categorias("Exitos de cine",ItemPelicula2))
        categorias.add(Categorias(" para ti",ItemPelicula2))
        categorias.add(Categorias("Recomendaciones  ti",ItemPelicula2))

        setCategoriasRecycleView(categorias)

    }

    private fun setCategoriasRecycleView(Categorias: List<Categorias>){
        categoriaRecicleView = findViewById(R.id.rvRecycleInicio)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        categoriaRecicleView!!.layoutManager = layoutManager
        recycleAdapter = RecycleViewAdapter(this, Categorias)
        categoriaRecicleView!!.adapter = recycleAdapter
    }
}