package com.example.examen_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.BaseDatos
import com.example.myapplication.SQLiteHelper

class ActualizarEstudiante : AppCompatActivity() {
    private lateinit var fechaR: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_estudiante)

        val nombreEstudiante = findViewById<EditText>(R.id.txtEditarNombreEstudiante)
        val EditarEdadEstudiante = findViewById<EditText>(R.id.txtEditarEdadEstudiante)
        val matricula = findViewById<EditText>(R.id.txtEditarMatricula)
        fechaR = findViewById<EditText>(R.id.txtEditarFecha)
        fechaR.setOnClickListener{ShowDatePickerDialog()}

        val calificacion = findViewById<EditText>(R.id.txtEditarCalificacion)

        val IdEst = intent.getParcelableExtra<BEstudiante>("estudiante")
        val id_EStudiante = IdEst!!.idEstudiante

        BaseDatos.BaseDatosSQLiteHelper= SQLiteHelper(this)

        nombreEstudiante.setText(IdEst?.nombreEstudiante)
        EditarEdadEstudiante.setText(IdEst?.Edad.toString())
        matricula.setText(IdEst?.segunda)
        fechaR.setText(IdEst?.fechaRegistro)
        calificacion.setText(IdEst?.Calificacion.toString())

        val btnGuardarEstudiante = findViewById<Button>(R.id.btnGuardarEst)
        btnGuardarEstudiante.setOnClickListener {
            val nombre = nombreEstudiante.text.toString()
            val edadEst = EditarEdadEstudiante.text.toString().toInt()
            val matriiculaEst = matricula.text.toString()
            val fechaRe = fechaR.text.toString()
            val calificacionEst = calificacion.text.toString().toDouble()

            if(nombreEstudiante.text.isNotBlank()&&EditarEdadEstudiante.text.isNotBlank() && matricula.text.isNotBlank()
                &&fechaR.text.isNotBlank()&&calificacion.text.isNotBlank()){
                BaseDatos.BaseDatosSQLiteHelper!!.actualizarEstudianteFormulario(nombre,
                    edadEst, matriiculaEst, fechaRe, calificacionEst, id_EStudiante)

                nombreEstudiante.text.clear()
                EditarEdadEstudiante.text.clear()
                matricula.text.clear()
                fechaR.text.clear()
                calificacion.text.clear()

                Log.i("Actualizar", "${nombre} -- ${fechaR} -- ${id_EStudiante}")

                Toast.makeText(this,"Se ha modificado", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Los campos no deben estar vacios", Toast.LENGTH_LONG).show()

            } }
    }

    fun ShowDatePickerDialog() {
        val datePicker = DatePickerFragment{day, month, year -> OnDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePcker")
    }

    fun OnDateSelected(day:Int, month:Int, year:Int){
        fechaR.setText("${day}/${month}/${year}")
    }
}