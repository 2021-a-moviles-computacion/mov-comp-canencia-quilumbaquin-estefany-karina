package com.example.moviles_computacion_2021_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GRecycleView : AppCompatActivity() {
    var totalLikes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grecycle_view)

        val listaEntrenador = arrayListOf<BEntrenador>()
        val ligaPokemon = DLiga("Kanto","Liga Kanto")
        listaEntrenador
            .add(BEntrenador("Kari", "1754501854", ligaPokemon))

        listaEntrenador
            .add(BEntrenador("Estefany", "1677801854", ligaPokemon))


    val recyclerViewBEntrenador = findViewById<RecyclerView>(R.id.rv_entrenadores)

    iniciarRecycleView(listaEntrenador, this, recyclerViewBEntrenador)
    }
    fun iniciarRecycleView(
        lista: List<BEntrenador>,
        actividad: GRecycleView,
        recycleView: RecyclerView
    ){
        val adaptador = FRecycleViewAdaptadorNombreCedula(
            actividad,
            lista,
            recycleView
        )
        recycleView.adapter = adaptador
        recycleView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recycleView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        adaptador.notifyDataSetChanged()

    }

    fun aumentarTotalLikes(){
        totalLikes = totalLikes +1
        val textview = findViewById<TextView>(R.id.tv_total_likes)
        textview.text = totalLikes.toString()
    }
}