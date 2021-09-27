package com.example.examen2b

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
            if(nombreProfesor.text.isNotBlank()&&materia.text.isNotBlank()&&edadProfesor.text.isNotBlank()&&estadoCivil.text.isNotBlank()
                &&telefono.text.isNotBlank()&&validartelefono(telefono.text.toString())){
                    if(validarNombre(nombreProfesor.text.toString())){
                        if(validarEdad(edadProfesor.text.toString())){
                            if(validarEstadoCivil(estadoCivil.text.toString())){
                                if(validarMateria(materia.text.toString())){
                                    if(validartelefono(telefono.text.toString())){
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
                .set(nuevoProfesor)
                .addOnSuccessListener {
                    Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!")
                }.addOnFailureListener {

                }
                Toast.makeText(this,"Profesor registrado exitosamente", Toast.LENGTH_SHORT).show()
                abrirActividad(Profesor::class.java)
                                    }else{
                                        Toast.makeText(this,"El teléfono es incorrecto", Toast.LENGTH_SHORT).show()}
                                }else{
                                    Toast.makeText(this,"La materia es incorrecto", Toast.LENGTH_SHORT).show()}
                            }else{
                                Toast.makeText(this,"El estado civil es incorrecto", Toast.LENGTH_SHORT).show()}
                        }else{
                        Toast.makeText(this,"La edad es incorrecta", Toast.LENGTH_SHORT).show()}
                    }else{
                        Toast.makeText(this,"El nombre es incorrecto", Toast.LENGTH_SHORT).show()}
            }else{
                Toast.makeText(this,"Llene todos los campos correctamente", Toast.LENGTH_SHORT).show()}
        }
    }
    fun validarNombre(texto: String):Boolean{
        val validar = Regex("^[a-zA-Z ]{3,30}\$")
        return validar.matches(texto)
    }
    fun validarMateria(texto: String):Boolean{
        val validar = Regex("^[a-zA-Z ]{3,30}\$")
        return validar.matches(texto)
    }
    fun validarEdad(texto: String):Boolean{
        val validar = Regex("^[0-9]{2}$")
        return validar.matches(texto)
    }
    fun validarEstadoCivil(texto: String):Boolean{
        val validar = Regex("^soltero|casado|divorciado$")
        return validar.matches(texto)
    }
    fun validartelefono(texto: String):Boolean{
        val validar = Regex("^(09[0-9]{8})|(02[0-9]{6})$")
        return validar.matches(texto)
    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
}