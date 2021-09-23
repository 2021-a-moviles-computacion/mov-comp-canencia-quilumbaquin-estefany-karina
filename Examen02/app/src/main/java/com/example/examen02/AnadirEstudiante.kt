package com.example.examen2b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.examen02.R

class AnadirEstudiante : AppCompatActivity() {
    private lateinit var fechaRegistro: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_estudiante)

        val nombreEstudiante = findViewById<EditText>(R.id.txtNombreEstudiante)
        val edadEstudiante = findViewById<EditText>(R.id.txtEdadEstudiante)
        val matricula = findViewById<EditText>(R.id.txtMatricula)
        val calificacion = findViewById<EditText>(R.id.txtCalificacion)
        val botoneditar = findViewById<Button>(R.id.btnAnadirEst)
        val id_P = Profesor.idProf //ESte es el id del profesor q ya existe
        fechaRegistro = findViewById(R.id.txtFecha)

        fechaRegistro.setOnClickListener{ShowDatePickerDialog()}

        botoneditar.setOnClickListener {
            val nombre = nombreEstudiante.text.toString()
            val edadEst = edadEstudiante.text.toString().toInt()
            val matriiculaEst = matricula.text.toString()
            val fecha = fechaRegistro.text.toString()
            val calificacionEst = calificacion.text.toString().toDouble()
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