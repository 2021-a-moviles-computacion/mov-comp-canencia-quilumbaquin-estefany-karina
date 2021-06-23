package com.example.moviles01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
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

        /*ListViewEjemplo
            .setOnItemLongClickListener{adapterView, view, posicion, id ->
                 Log.i("List-view", "Dio click  ${posicion}")
        return@setOnItemLongClickListener true
            }*/
        registerForContextMenu(ListViewEjemplo)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater= menuInflater
        inflater.inflate(R.menu.menu, menu)
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