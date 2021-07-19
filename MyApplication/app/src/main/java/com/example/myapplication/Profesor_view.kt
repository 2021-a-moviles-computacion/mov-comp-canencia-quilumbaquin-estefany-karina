package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
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
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.BaseDatosProfesor.Companion.arregloBProfesor

class Profesor_view : AppCompatActivity() {
    var posicionItemSeleccionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor_view)

        val arregloNumeros = BaseDatosProfesor.arregloBProfesor

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,    //Layout precargado por Android (visual)
            arregloNumeros
        )

        val listViewProfesor = findViewById<ListView>(R.id.lv_profesor)
        listViewProfesor.adapter = adaptador

        val btnAnadirProfesor = findViewById<Button>(R.id.btn_anadirProf)
        btnAnadirProfesor.setOnClickListener {
            anadirItemsAListView(
                BProfesor(0, "d@d.com","",23,"soltero","2380453"),
                arregloNumeros,
                adaptador
            )
        }

        //boton añadir profesor
        val btnaddProfesor = findViewById<Button>(
            R.id.btn_anadirProf
        )

        btnaddProfesor.setOnClickListener{
            abrirActividad(RegistroProfesor::class.java)
        }

        listViewProfesor
            .setOnItemClickListener { adapterView, view, posicion, id ->
                Log.i("list-view", "Dio click ${posicion}")
            }
        listViewProfesor
            .setOnItemLongClickListener { adapterView, view, posicion, id ->
                Log.i("list-view", "Dio click ${posicion}")
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Titulo")
//                builder.setMessage("Mensaje")

                val seleccionUsuario = booleanArrayOf(
                    true,
                    false,
                    false
                )

                val opciones = resources.getStringArray(R.array.string_array_opciones_dialogo)
                builder.setMultiChoiceItems(
                    opciones,
                    seleccionUsuario,
                    {
                            dialog, wich, isChecked ->
                        Log.i("list-view" ,"${wich} ${isChecked}")
                    }
                )

                builder.setPositiveButton(
                    "Si",
                    DialogInterface.OnClickListener { dialog, which ->
                        Log.i("list-vire", "Sí")
                    }
                )
                builder.setNegativeButton(
                    "No",
                    null
                )
                val dialogo = builder.create()
                dialogo.show()

                return@setOnItemLongClickListener true
            }

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        posicionItemSeleccionado = id
        Log.i("list-view", "List view ${posicionItemSeleccionado}")
        Log.i("list-view", "Entrenador ${BaseDatosProfesor.arregloBProfesor[id]}")
    }


    fun abrirActividad(
        clase: Class<*>
    ){
        val intentExplicito = Intent(
            this,
            clase
        )
        this.startActivity(intentExplicito);
    }

    fun anadirItemsAListView(
        valor: BProfesor,
        arreglo: ArrayList<BProfesor>,
        adaptador: ArrayAdapter<BProfesor>
    ) {
        arreglo.add(valor)
        adaptador.notifyDataSetChanged()        //Actualiza la interfaz
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            //Editar
            R.id.miEditar -> {
                Log.i(
                    "list-view", "Editar ${
                        BaseDatosProfesor.arregloBProfesor[
                                posicionItemSeleccionado
                        ]
                    }"
                )
                return true
            }
            //Eliminar
            R.id.miEliminar -> {
                Log.i(
                    "list-view", "Eliminar ${
                        BaseDatosProfesor.arregloBProfesor[
                                posicionItemSeleccionado
                        ]
                    }"
                )
                return true
            }

            else -> super.onContextItemSelected(item)
        }
    }
}