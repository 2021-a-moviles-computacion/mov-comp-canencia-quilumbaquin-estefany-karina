package com.example.examen_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.BaseDatos
import com.example.myapplication.SQLiteHelper

class AnadirEstudiante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_estudiante)

        BaseDatos.BaseDatosSQLiteHelper = SQLiteHelper(this)
        val a = intent.getParcelableExtra<BProfesor>("profesor")
        val nombreEstudiante = findViewById<EditText>(R.id.txtNombreEstudiante)
        val edadEstudiante = findViewById<EditText>(R.id.txtEdadEstudiante)
        val matricula = findViewById<EditText>(R.id.txtMatricula)
        val fechaRegistro = findViewById<EditText>(R.id.txtFecha)
        val calificacion = findViewById<EditText>(R.id.txtCalificacion)
        val botoneditar = findViewById<Button>(R.id.btnAnadirEst)

        botoneditar.setOnClickListener {
            val nombre = nombreEstudiante.text.toString()
            val edadEst = edadEstudiante.text.toString().toInt()
            val matriiculaEst = matricula.text.toString()
            val fecha = fechaRegistro.text.toString()
            val calificacionEst = calificacion.text.toString().toDouble()
            if (nombre.isEmpty() || fecha.isEmpty() || matriiculaEst.isEmpty()) {
                Toast.makeText(this, "Existen campos vacios", Toast.LENGTH_LONG).show()
            } else {
                val estado = BaseDatos.BaseDatosSQLiteHelper!!.crearEstudiante(
                    nombre,
                    edadEst,
                    matriiculaEst,
                    fecha,
                    calificacionEst
                )
                nombreEstudiante.setText("")
                edadEstudiante.setText("")
                matricula.setText("")
                fechaRegistro.setText("")
                calificacion.setText("")

                if (estado != null) {
                    Toast.makeText(this, "Estudiante añadido", Toast.LENGTH_LONG).show()
                    Log.i("añadir", "${nombre} ---> ${fecha}")
                } else {
                    Toast.makeText(this, "usuario no añadido", Toast.LENGTH_LONG).show()

                }
            }
        }

    }
}