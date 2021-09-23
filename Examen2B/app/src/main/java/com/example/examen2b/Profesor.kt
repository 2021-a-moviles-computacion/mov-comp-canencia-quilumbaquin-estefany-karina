package com.example.examen2b

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
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Profesor : AppCompatActivity() {
    companion object{
        var idProf = ""
        var nombrePro = "profesor"
    }

    var arregloProf = ArrayList<BProfesor>()
    var posicionItem = 0
    var adapter: ArrayAdapter<BProfesor>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesor)

        val db = Firebase.firestore
        var documentoProfesor: (MutableList<DocumentSnapshot>)
        var referencia = db.collection("profesor")
        referencia.get()
            .addOnSuccessListener {
                documentoProfesor = it.documents
                documentoProfesor.forEach { iteracion ->
                    arregloProf.add(
                        BProfesor(iteracion.get("nombre").toString(),
                            iteracion.get("materia").toString(),
                            iteracion.get("edad").toString().toInt(),
                            iteracion.get("estadoCivil").toString(),
                            iteracion.get("telefono").toString(),
                        )
                    )

                }
                if(arregloProf.size > 0) {
                    adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arregloProf)
                    val listViewProfesor = findViewById<ListView>(R.id.ltvProfesor)
                    listViewProfesor.adapter = adapter
                    registerForContextMenu(listViewProfesor)
                }
            }
        val  btnNuevoProfesor = findViewById<Button>(R.id.btn_anadirProfesor)
        btnNuevoProfesor.setOnClickListener{ abrirActividad(AnadirProfesor::class.java)
        }
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
        idProf = "${adapter!!.getItem(posicionItem)!!.nombreProfesor.toString()}-${adapter!!.getItem(posicionItem)!!.materia.toString()}"
        nombrePro = adapter!!.getItem(posicionItem)!!.nombreProfesor.toString()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var Aprofesor = adapter!!.getItem(posicionItem)
        return when(item?.itemId){

            //Editar
            R.id.editarProfesor-> {

                if (Aprofesor != null) {
                    this.startActivity(Intent(this,ActualizarProfesor::class.java).putExtra("profesor",Aprofesor))                }
                return true }

            //Eliminar
            R.id.eliminarProfesor -> {

                AlertDialog.Builder(this).apply {
                    setTitle("Alerta")
                    setMessage("¿Desea eliminar el registro?")
                    setPositiveButton("Si"){ _: DialogInterface, _: Int ->
                        val db = Firebase.firestore
                        var refCasa = db.collection("estudiante")
                        Estudiante.arregloEst.forEach {
                            db.collection("profesor").document("${Aprofesor!!.nombreProfesor}-${Aprofesor!!.materia}")
                                .collection("estudiante").document("${it.nombreEstudiante}-${it.fechaRegistro}") .delete()
                        }

                        db.collection("profesor").document("${Aprofesor!!.nombreProfesor}-${Aprofesor!!.materia}").delete()
                        adapter?.remove(adapter!!.getItem(posicionItem));
                    }
                    setNegativeButton("No", null)
                }.show()

                return true }
            //Ver Estudiantes
            R.id.menuEstudiantes -> {

                if (Aprofesor != null) {
                    this.startActivity(Intent(this,Estudiante::class.java).putExtra("profesor",Aprofesor))
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

    }

}