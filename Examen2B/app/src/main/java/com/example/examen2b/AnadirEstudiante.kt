package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AnadirEstudiante : AppCompatActivity() {
    private lateinit var fechaRegistro: EditText

    companion object{
        var nombreEst = ""
    }
    var arregloUbicaciones = ArrayList<ubicacion>()
    var ubicacionSeleccionado: ubicacion? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_estudiante)

        val nombreEstudiante = findViewById<EditText>(R.id.txtNombreEstudiante)
        val edadEstudiante = findViewById<EditText>(R.id.txtEdadEstudiante)
        val matricula = findViewById<EditText>(R.id.txtMatricula)
        val calificacion = findViewById<EditText>(R.id.txtCalificacion)
        val botoneditar = findViewById<Button>(R.id.btnAnadirEst)
        val id_P = Profesor.idProf //ESte es el id del profesor q ya existe
        //var altitud = findViewById<EditText>(R.id.txtaltitud)
        //var latitud = findViewById<EditText>(R.id.txtlatitud)

        fechaRegistro = findViewById(R.id.txtFecha)
        fechaRegistro.setOnClickListener{ShowDatePickerDialog()}
        var documentoUbicacion: (MutableList<DocumentSnapshot>)

        val db = Firebase.firestore

        var referencia = db.collection("ubicacion")
            referencia.get()
            .addOnSuccessListener {
                documentoUbicacion = it.documents
                documentoUbicacion.forEach { iteracion ->
                    arregloUbicaciones.add(
                        ubicacion(iteracion.get("nombre").toString(),
                            iteracion.get("latitud").toString().toDouble(),
                            iteracion.get("longitud").toString().toDouble())
                    )

                }

                var spinnerRestaurantes = findViewById<Spinner>(R.id.sp_ubicacíon)
                val adaptadorRestaurantes = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    arregloUbicaciones
                )
                spinnerRestaurantes.adapter = adaptadorRestaurantes
                spinnerRestaurantes.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        ubicacionSeleccionado = arregloUbicaciones[position]
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
            }

        botoneditar.setOnClickListener {
            val nombre = nombreEstudiante.text.toString()
            val edadEst = edadEstudiante.text.toString().toInt()
            val matriiculaEst = matricula.text.toString()
            val fecha = fechaRegistro.text.toString()
            val calificacionEst = calificacion.text.toString().toDouble()
            val nuevoEstudiante = hashMapOf<String, Any>(
                "nombre" to nombre,
                "edad" to edadEst,
                "matricula" to matriiculaEst,
                "fecha" to fecha,
                "calificacion" to calificacionEst,
                "altitud" to ubicacionSeleccionado!!.longitud.toString(),
                "latitud" to ubicacionSeleccionado!!.latitud.toString(),

                )
            val db = Firebase.firestore
            val referencia = db.collection("profesor").document(id_P).collection("estudiante")
                .document("${nombreEstudiante.text}")
            referencia.set(nuevoEstudiante).addOnSuccessListener {
                nombreEstudiante.text.clear()
                edadEstudiante.text.clear()
                matricula.text.clear()
                fechaRegistro.text.clear()
                calificacion.text.clear()

            }.addOnFailureListener {}
        }
    }

    fun ShowDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year -> OnDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePcker")
    }

    fun OnDateSelected(day:Int, month:Int, year:Int){
        fechaRegistro.setText("${day}/${month}/${year}")
    }

}