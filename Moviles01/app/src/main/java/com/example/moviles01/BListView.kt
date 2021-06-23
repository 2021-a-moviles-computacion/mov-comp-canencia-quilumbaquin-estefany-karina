package com.example.moviles01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class BListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_list_view)

        val arregloNumero = arrayListOf<Int>(1,2,3)

        val adaptador = ArrayAdapter(
            this, //contexto
            android.R.layout.simple_list_item_1,//LAYOUT VISUAL
            arregloNumero //ARREGLO
                )
        val ListViewEjemplo = findViewById<ListView>(R.id.ltv_ejemplo)
        ListViewEjemplo.adapter = adaptador

        val botonAnadirNumero = findViewById<Button>(R.id.btn_anadir_numero)
        botonAnadirNumero.setOnClickListener { anadirItemsAllListView(
            1,
            arregloNumero,
            adaptador
        ) }
    }

    fun anadirItemsAllListView(
        valor: Int,
        arreglo: ArrayList<Int>,
        adaptador: ArrayAdapter<Int>
    ){
        arreglo.add(valor)
        adaptador.notifyDataSetChanged()//Actualiza la interfaz
    }
}