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
    var CODIGO_RESPUESTA_INTENT_EXPLICITO = 404

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_estudiante)

        val nombreEstudiante = findViewById<EditText>(R.id.txtEditarNombreEstudiante)
        val edadEstudiante = findViewById<EditText>(R.id.txtEditarEdad)
        val matricula = findViewById<EditText>(R.id.txtEditarMatricula)
        val fechaR = findViewById<EditText>(R.id.txtEditarFecha)
        val calificacion = findViewById<EditText>(R.id.txtEditarCalificacion)

        val IdEst = intent.getParcelableExtra<BEstudiante>("estudiante")
        val id_EStudiante = IdEst!!.idEstudiante

        BaseDatos.BaseDatosSQLiteHelper= SQLiteHelper(this)

        nombreEstudiante.setText(IdEst?.nombreEstudiante)
        //edadEstudiante.setText(IdEst?.Edad.toString().toInt())
        matricula.setText(IdEst?.segunda)
        fechaR.setText(IdEst?.fechaRegistro)
        calificacion.setText(IdEst?.Calificacion.toString())

        val btnGuardarEstudiante = findViewById<Button>(R.id.btnGuardarEst)
        btnGuardarEstudiante.setOnClickListener {
            val nombre = nombreEstudiante.text.toString()
            val edadEst = edadEstudiante.text.toString().toInt()
            val matriiculaEst = matricula.text.toString()
            val fechaRe = fechaR.text.toString()
            val calificacionEst = calificacion.text.toString().toDouble()

            if(nombreEstudiante.text.isNotBlank()&&edadEstudiante.text.isNotBlank() && matricula.text.isNotBlank()
                &&fechaR.text.isNotBlank()&&calificacion.text.isNotBlank()){
                BaseDatos.BaseDatosSQLiteHelper!!.actualizarEstudianteFormulario(nombre,
                    edadEst, matriiculaEst, fechaRe, calificacionEst, id_EStudiante)

                nombreEstudiante.text.clear()
                edadEstudiante.text.clear()
                matricula.text.clear()
                fechaR.text.clear()
                calificacion.text.clear()

                Log.i("Actualizar", "${nombre} -- ${fechaR} -- ${id_EStudiante}")

                Toast.makeText(this,"Se ha modificado", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Los campos no deben estar vacios", Toast.LENGTH_LONG).show()

            } }
    }

    fun abrirActividad(clase: Class<*>) {
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