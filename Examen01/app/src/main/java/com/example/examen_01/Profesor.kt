package com.example.examen_01

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
class Profesor : AppCompatActivity() {

    companion object{
        var idProf = 0
    }
    var posicionItem = 0
    var adapter: ArrayAdapter<BProfesor>? = null
    val CODIGO_RESPUESTA_INTENT_EXPLICITO = 401

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor)

        BaseDatos.BaseDatosSQLiteHelper= SQLiteHelper(this)

        if(BaseDatos.BaseDatosSQLiteHelper != null) {
            val profesor = BaseDatos.BaseDatosSQLiteHelper!!.consultarProfesores()
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, profesor)
            val listViewUsuario = findViewById<ListView>(R.id.ltvProfesor)
            listViewUsuario.adapter = adapter
            registerForContextMenu(listViewUsuario)

        }

        val  btnNuevoProfesor = findViewById<Button>(R.id.btn_anadirProfesor)
        btnNuevoProfesor.setOnClickListener{ abrirActividad(AnadirProfesor::class.java)}
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_profesor,menu)

        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        posicionItem = id
        idProf = adapter!!.getItem(posicionItem)!!.idProfesor
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var Aprofesor = adapter!!.getItem(posicionItem)

        return when(item?.itemId){

            //Editar
            R.id.editarProfesor-> {

                if (Aprofesor != null) {
                    abrirActividadConParametros(ActualizarProfesor::class.java,Aprofesor)
                }

                return true
            }

            //Eliminar
            R.id.eliminarProfesor -> {
                if(BaseDatos.BaseDatosSQLiteHelper!=null){

                    AlertDialog.Builder(this).apply {
                        setTitle("Alerta")
                        setMessage("¿Desea eliminar el registro?")
                        setPositiveButton("Si"){ _: DialogInterface, _: Int ->
                            BaseDatos.BaseDatosSQLiteHelper!!.eliminarProfesorFormulario(Aprofesor!!.idProfesor)
                            adapter?.remove(adapter!!.getItem(posicionItem));

                        }
                        setNegativeButton("No", null)
                    }.show()


                }
                return true }
            //Ver Casas
            R.id.menuEstudiantes -> {

                if (Aprofesor != null) {
                    abrirActividadConParametros(Estudiante::class.java,Aprofesor)
                }



                return true }

            else -> super.onContextItemSelected(item)
        }
    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }

    fun abrirActividadConParametros(clase: Class<*>, profesor: BProfesor, ){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("profesor",profesor)
        startActivityForResult(intentExplicito,CODIGO_RESPUESTA_INTENT_EXPLICITO)

    }

}