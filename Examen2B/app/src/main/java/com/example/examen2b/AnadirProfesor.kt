package com.example.examen2b

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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

        btnGuardarProfesor.setOnClickListener {
            val nombre = nombreProfesor.text.toString()
            val materiaP = materia.text.toString()
            val edadProfesor1 = edadProfesor.text.toString()
            val EstadoCivil = estadoCivil.text.toString()
            val telefono1 = telefono.text.toString()

            val db = Firebase.firestore
            val nuevoProfesor = hashMapOf<String, Any>(
                "nombre" to nombre,
                "materia" to materiaP,
                "edad" to edadProfesor1,
                "estadoCivil" to EstadoCivil,
                "telefono" to telefono1,)

            db.collection("profesor").document("${nombreProfesor.text}")
                //referencia.add(nuevoProfesor)
                .set(nuevoProfesor)
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!")
                }.addOnFailureListener {

                }
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
}