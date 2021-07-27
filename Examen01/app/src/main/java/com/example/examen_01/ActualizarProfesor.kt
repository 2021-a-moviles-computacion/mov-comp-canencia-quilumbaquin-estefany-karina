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

@Suppress("DEPRECATION")
class ActualizarProfesor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_profesor)

        val ProfesorEst = intent.getParcelableExtra<BProfesor>("profesor")
        val editarNombre = findViewById<EditText>(R.id.txtEditarNombreProfesor)
        val editarMateria =  findViewById<EditText>(R.id.txtEditarMateria)
        val editarEdad =  findViewById<EditText>(R.id.txtEditarEdad)
        val editarEstadoCivil =  findViewById<EditText>(R.id.txtEditarEstado)
        val editarTelefono =  findViewById<EditText>(R.id.txtEditarTelefono)
        val idProfesor:Int = ProfesorEst!!.idProfesor
        BaseDatos.BaseDatosSQLiteHelper= SQLiteHelper(this)



        editarNombre.setText(ProfesorEst?.nombreProfesor.toString())
        editarMateria.setText(ProfesorEst?.materia.toString())
        editarEdad.setText(ProfesorEst?.edadProfesor.toString())
        editarEstadoCivil.setText(ProfesorEst?.estadoCivil.toString())
        editarTelefono.setText(ProfesorEst?.telefono.toString())


        val botoneditar = findViewById<Button>(R.id.btn_editar)
        botoneditar.setOnClickListener {
            var nombre = editarNombre.text.toString()
            var materia = editarMateria.text.toString()
            var edad = editarEdad.text.toString().toInt()
            var estado = editarEstadoCivil.text.toString()
            var telefono = editarTelefono.text.toString()
            var idProfesor = idProfesor

            if(editarNombre.text.isNotBlank()&&editarMateria.text.isNotBlank() && editarEdad.text.isNotBlank()
                &&editarEstadoCivil.text.isNotBlank()&&editarTelefono.text.isNotBlank()){
                BaseDatos.BaseDatosSQLiteHelper!!.actualizarProfesorFormulario(nombre,
                    materia, edad, estado, telefono, idProfesor)

                editarNombre.text.clear()
                editarMateria.text.clear()
                editarEdad.text.clear()
                editarEstadoCivil.text.clear()
                editarTelefono.text.clear()

                Log.i("Actualizar", "${nombre} -- ${materia} -- ${idProfesor}")

                Toast.makeText(this,"Se ha modificado", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Los campos no deben estar vacios", Toast.LENGTH_LONG).show()

            } }

    }
}