package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ActualizarEstudiante : AppCompatActivity() {
    private lateinit var fechaR: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_estudiante)

        var EditarEst = intent.getSerializableExtra("estudiante") as BEstudiante

        val nombreEstudiante = findViewById<EditText>(R.id.txtEditarNombreEstudiante)
        val EditarEdadEstudiante = findViewById<EditText>(R.id.txtEditarEdadEstudiante)
        val matricula = findViewById<EditText>(R.id.txtEditarMatricula)
        fechaR = findViewById<EditText>(R.id.txtEditarFecha)
        fechaR.setOnClickListener{ShowDatePickerDialog()}
        val calificacion = findViewById<EditText>(R.id.txtEditarCalificacion)
        val editarLatitud = findViewById<EditText>(R.id.et_ed_latitud)
        val editarAltitud = findViewById<EditText>(R.id.et_ed_altitud)

        val nombreEstDoc = Estudiante.nombreEst

        nombreEstudiante.setText(EditarEst.nombreEstudiante)
        EditarEdadEstudiante.setText(EditarEst.Edad.toString())
        matricula.setText(EditarEst?.segunda)
        fechaR.setText(EditarEst?.fechaRegistro)
        calificacion.setText(EditarEst?.Calificacion.toString())
        editarLatitud.setText(EditarEst.latitud.toString())
        editarAltitud.setText(EditarEst.altitud.toString())

        val btnGuardarEstudiante = findViewById<Button>(R.id.btnGuardarEst)
        btnGuardarEstudiante.setOnClickListener {
            val nombre = nombreEstudiante.text.toString()
            val edadEst = EditarEdadEstudiante.text.toString().toInt()
            val matriiculaEst = matricula.text.toString()
            val fechaRe = fechaR.text.toString()
            val calificacionEst = calificacion.text.toString().toDouble()
            val latirud = editarLatitud.text.toString().toDouble()
            val altitud = editarAltitud.text.toString().toDouble()

            val actualizarEst = hashMapOf<String, Any>(
                "nombre" to nombre,
                "edad" to edadEst,
                "matricula" to matriiculaEst,
                "fecha" to fechaRe,
                "calificacion" to calificacionEst,
                "latitud" to latirud,
                "altitud" to altitud,

                )

            val db = Firebase.firestore
            val referencia = db.collection("profesor/${Profesor.idProf}/estudiante").document(nombreEstDoc)
            referencia.set(actualizarEst).addOnSuccessListener {
                nombreEstudiante.setText("")
                EditarEdadEstudiante.setText("")
                matricula.setText("")
                fechaR.setText("")
                calificacion.setText("")
                editarLatitud.setText("")
                editarAltitud.setText("")


            }.addOnFailureListener {

            }

            abrirActividad(Estudiante::class.java)

        }

    }
    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
    fun ShowDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year -> OnDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePcker")
    }

    fun OnDateSelected(day:Int, month:Int, year:Int){
        fechaR.setText("${day}/${month}/${year}")
    }
}