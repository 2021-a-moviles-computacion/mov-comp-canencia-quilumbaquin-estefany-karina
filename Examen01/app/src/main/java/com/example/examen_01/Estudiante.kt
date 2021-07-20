package com.example.examen_01

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
import com.example.myapplication.BaseDatos
import com.example.myapplication.SQLiteHelper

@Suppress("DEPRECATION")
class Estudiante : AppCompatActivity() {

    var adapter: ArrayAdapter<BEstudiante>? = null
    var CODIGO_RESPUESTA_INTENT_EXPLICITO = 402
    var CODIGO_RESPUESTA_INTENT_EXPLICITO3 = 405
    var posicionItem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiante)

        val profesor= intent.getParcelableExtra<BProfesor>("profesor")
        val id = Profesor.idProf

        BaseDatos.BaseDatosSQLiteHelper= SQLiteHelper(this)

        if(BaseDatos.BaseDatosSQLiteHelper != null) {
            adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                BaseDatos.BaseDatosSQLiteHelper!!.consultarEstudiante(id)
            )
            val listViewEstudiante = findViewById<ListView>(R.id.ltvEstudiantes)
            listViewEstudiante.adapter = adapter
            registerForContextMenu(listViewEstudiante)
        }


        val btnAnadirEstudiante = findViewById<Button>(R.id.btnAnadirEstudiante)
        btnAnadirEstudiante.setOnClickListener{
            abrirActividadConParametros3(AnadirEstudiante::class.java, profesor!!)

        }

    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_estudiante,menu)

        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        posicionItem = id
        Log.i("bdd","Selección: ${posicionItem}")


    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        var estudiante = adapter!!.getItem(posicionItem)

        return when(item?.itemId){


            R.id.editarEstudiante-> {


                abrirActividadConParametros(ActualizarEstudiante::class.java,estudiante!!)


                return true
            }


            R.id.menuProfesor -> {

                if(BaseDatos.BaseDatosSQLiteHelper!=null){

                    AlertDialog.Builder(this).apply {
                        setTitle("Alerta")
                        setMessage("¿Desea eliminar el registro?")
                        setPositiveButton("Si"){ _: DialogInterface, _: Int ->
                            BaseDatos.BaseDatosSQLiteHelper!!.eliminarEstudianteFormulario(adapter!!.getItem(posicionItem)!!.idEstudiante)
                            adapter?.remove(adapter!!.getItem(posicionItem));

                        }
                        setNegativeButton("No", null)
                    }.show()


                }
                return true }


            else -> super.onContextItemSelected(item)
        }
    }

    fun abrirActividadConParametros(clase: Class<*>, estudiante: BEstudiante){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("estudiante",estudiante)
        startActivityForResult(intentExplicito,CODIGO_RESPUESTA_INTENT_EXPLICITO)

    }



    fun abrirActividadConParametros3(clase: Class<*>, profesor: BProfesor){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("profesor",profesor)
        startActivityForResult(intentExplicito,CODIGO_RESPUESTA_INTENT_EXPLICITO3)

    }



    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }

}