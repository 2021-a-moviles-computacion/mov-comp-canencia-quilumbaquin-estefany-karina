package com.example.moviles01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class BListView : AppCompatActivity() {
    var posicionItemSeleccionado = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_list_view)

        //val arregloNumero = arrayListOf<Int>(1,2,3)

        val arregloNumero = BBaseDatosMemoria.arregloBEntrenador
        val adaptador = ArrayAdapter(
            this, //contexto
            android.R.layout.simple_list_item_1,//LAYOUT VISUAL
            arregloNumero //ARREGLO
                )
        val ListViewEjemplo = findViewById<ListView>(R.id.ltv_ejemplo)
        ListViewEjemplo.adapter = adaptador

        val botonAnadirNumero = findViewById<Button>(R.id.btn_anadir_numero)
        botonAnadirNumero.setOnClickListener {
            anadirItemsAllListView(
                BEntrenador("Prueba", "d@d.com"),
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

        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        posicionItemSeleccionado = id
        Log.i("List-view", "Liste view ${posicionItemSeleccionado}")
        Log.i("List-view", "Entrenador ${BBaseDatosMemoria.arregloBEntrenador[id]}")
    }


    fun anadirItemsAllListView(
            valor: BEntrenador,
            arreglo: ArrayList<BEntrenador>,
            adaptador: ArrayAdapter<BEntrenador>
    ){
        arreglo.add(valor)
        adaptador.notifyDataSetChanged()//Actualiza la interfaz
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            //EDITAR
            R.id.mi_editar -> {
                Log.i("List-vuew", "Editar ${BBaseDatosMemoria.arregloBEntrenador[
                        posicionItemSeleccionado
                ]}")
                return true
            }
            //ELIMINAR
            R.id.mi_eliminar -> {
                Log.i("List-view", "Eliminar ${BBaseDatosMemoria.arregloBEntrenador[
                        posicionItemSeleccionado
                ]}")
                return true
            }

            else -> super.onContextItemSelected(item)
        }
    }
}