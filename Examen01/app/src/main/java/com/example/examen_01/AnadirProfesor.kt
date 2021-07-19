package com.example.examen_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.BaseDatos
import com.example.myapplication.SQLiteHelper

class AnadirProfesor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anadir_profesor)

        val btnGuardarProfesor = findViewById<Button>(R.id.btn_guardarProfesor)
        val nombreProfesor = findViewById<EditText>(R.id.txtNombreProfesor)
        val materia =  findViewById<EditText>(R.id.txtMateria)
        val edadProfesor =  findViewById<EditText>(R.id.txtEdadProfesor)
        val estadoCivil =  findViewById<EditText>(R.id.txtEstadoCivil)
        val telefono  =  findViewById<EditText>(R.id.txtTelefono)
        BaseDatos.BaseDatosSQLiteHelper = SQLiteHelper(this)

        btnGuardarProfesor.setOnClickListener {
            val nombre = nombreProfesor.text.toString()
            val materia = materia.text.toString()
            val edadProfesor = edadProfesor.text.toString().toInt()
            val EstadoCivil = estadoCivil.text.toString()
            val telefono = telefono.text.toString()
            if(nombre.isEmpty() || materia.isEmpty() ){
            Toast.makeText(this,"ingrese el requerimiento", Toast.LENGTH_SHORT).show()
        }else{
            val estado = BaseDatos.BaseDatosSQLiteHelper!!.crearProfesor(nombre, materia, edadProfesor, EstadoCivil, telefono)

            if (estado != null){
                Toast.makeText(this,"usuario añadido", Toast.LENGTH_SHORT).show()

                Log.e("añadir","${nombre} ---> ${materia}")
            }else{
                Toast.makeText(this,"usuario no añadido", Toast.LENGTH_SHORT).show()

            }
        } }
    }
    }

   /* fun anadirUsuario(){
        val nombre = nombreProfesor.text.toString()
        val materia = materia.text.toString()
        val edadProfesor = edadProfesor.text.toString().toInt()
        val EstadoCivil = estadoCivil.text.toString()
        val telefono = telefono.text.toString()

        if(nombre.isEmpty() || materia.isEmpty() ){
            Toast.makeText(this,"ingrese el requerimiento", Toast.LENGTH_SHORT).show()
        }else{
            val estado = sqliteHelper.crearProfesor(nombre, materia, edadProfesor, EstadoCivil, telefono)

            if (estado != null){
                Toast.makeText(this,"usuario añadido", Toast.LENGTH_SHORT).show()
                borrarTexto()
                Log.e("añadir","${nombre} ---> ${materia}")
            }else{
                Toast.makeText(this,"usuario no añadido", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun borrarTexto(){
        nombreProfesor.setText("")
        materia.setText("")
        edadProfesor.setText("")
        estadoCivil.setText("")
        telefono.setText("")
    }
*/