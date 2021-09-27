package com.example.examen2b

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
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Estudiante : AppCompatActivity() {
    companion object{
        var arregloEstudiante1 = ArrayList<BEstudiante>()
        var nombreEst = "estudiante"
    }
    var arregloEstudiante = ArrayList<BEstudiante>()
    var adapter: ArrayAdapter<BEstudiante>? = null
    var posicionItem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiante)
       // var nombre = Profesor.nombrePro

        var id = Profesor.idProf
        println("------------------------------------------------>${id}")
        val db = Firebase.firestore
        val listViewUsuario = findViewById<ListView>(R.id.ltvEstudiantes)

        var documentoRestaurante: (MutableList<DocumentSnapshot>)
        var referencia = db.collection("profesor/$id/estudiante")
               .get().addOnSuccessListener {
                documentoRestaurante = it.documents
                documentoRestaurante.forEach { iteracion ->
                    arregloEstudiante.add(BEstudiante(
                            iteracion.get("nombre").toString(),
                            iteracion.get("edad").toString().toInt(),
                            iteracion.get("matricula").toString(),
                            iteracion.get("fecha").toString(),
                            iteracion.get("calificacion").toString().toDouble(),
                            iteracion.get("altitud").toString().toDouble(),
                            iteracion.get("latitud").toString().toDouble(),))
                }
                arregloEstudiante1 = arregloEstudiante
                if(arregloEstudiante.size > 0) {
                    adapter =ArrayAdapter(this, android.R.layout.simple_list_item_1, arregloEstudiante)
                    listViewUsuario.adapter = adapter
                    registerForContextMenu(listViewUsuario)
                }else{

                }}

        val btn_añadir = findViewById<Button>(R.id.btnAnadirEstudiante)
        btn_añadir.setOnClickListener {
            abrirActividad(AnadirEstudiante::class.java)
        }
        val btn_irProfesores = findViewById<Button>(R.id.btn_pantallaProf)
        btn_irProfesores.setOnClickListener {
            abrirActividad(Profesor::class.java)
        }
    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
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
        nombreEst = "${adapter!!.getItem(posicionItem)!!.nombreEstudiante.toString()}"
        Log.i("bdd","Selección: ${posicionItem}")


    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        var estudiante = adapter!!.getItem(posicionItem)

        return when(item?.itemId){


            R.id.editarEstudiante-> {

                if(estudiante != null) {
                    this.startActivity(Intent(this,ActualizarEstudiante::class.java).putExtra("estudiante",estudiante))
                }
                return true
            }

            R.id.menuProfesor -> {

                    AlertDialog.Builder(this).apply {
                        setTitle("Alerta")
                        setMessage("¿Desea eliminar el registro?")
                        setPositiveButton("Si") { _: DialogInterface, _: Int ->

                            val db = Firebase.firestore
                            db.collection("profesor").document("${Profesor.idProf}").collection("estudiante")
                                .document("${estudiante!!.nombreEstudiante}").delete()
                            adapter?.remove(adapter!!.getItem(posicionItem));

                        }
                        setNegativeButton("No", null)
                    }.show()

                return true }

            R.id.mapa ->{

                if (estudiante != null) {
                    this.startActivity(Intent(this,Ubicacion1::class.java).putExtra("estudiante",estudiante))
                }

                return true
            }


            else -> super.onContextItemSelected(item)
        }
    }
}